package com.service.applehip.web.dto.chat

import com.service.applehip.domain.chat.ChatRoomInfo
import com.service.applehip.domain.chat.ChatRoomList
import com.service.applehip.domain.chat.ChatRoomListId

class ChatRoomInfoSaveRequest(
        var userList : String = "",
        var regUserNo : Long? = null
) {
    fun toEntity() =
            ChatRoomInfo(
                    userList = this.userList,
                    regUserNo = this.regUserNo
            )
}

/**
 * 채팅방 생성을 위한 request DTO
 * requestUserNo : 생성요청한 user no
 * targetUserNo : 채팅한 상대 user no
 */
class MakeChatRoomRequest(
        var requestUserNo : Long,
        var targetUserNo : Long
) {
    /**
     * CHATROOM_INFO entity를 생성하기 위한 메소드
     * @param seq : 채팅방 인포 순번 (TABLE_SEQ 에서 가져옴)
     */
    fun chatRoomInfoEntity(seq : Long) =
            ChatRoomInfo(
                    id = seq,
                    userList = "${this.requestUserNo}|${this.targetUserNo}",
                    regUserNo = this.requestUserNo
            )

    /**
     * 채팅방 생성요청자의 채팅방 목록에 현재 채팅방을 추가
     */
    fun addChatRoomListForRequestUserEntity(chatRoomInfoId : Long) =
            ChatRoomList(
                    id = ChatRoomListId(
                            userNo = this.requestUserNo,
                            chatroomId = chatRoomInfoId
                    )
            )

    /**
     * 채팅방 대상자의 채팅방 목록에 현재 채팅방을 추가
     */
    fun addChatRoomListForTargetUserEntity(chatRoomInfoId : Long) =
            ChatRoomList(
                    id = ChatRoomListId(
                            userNo = this.targetUserNo,
                            chatroomId = chatRoomInfoId
                    )
            )
}