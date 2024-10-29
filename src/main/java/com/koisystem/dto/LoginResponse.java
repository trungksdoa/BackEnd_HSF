package com.koisystem.dto;

import com.koisystem.models.UserInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String token;
    private UserInfo user;
}
