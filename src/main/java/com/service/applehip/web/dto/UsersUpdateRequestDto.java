package com.service.applehip.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersUpdateRequestDto {
    private String password;

    @Builder
    public UsersUpdateRequestDto(String password){
        this.password = password;
    }
}
