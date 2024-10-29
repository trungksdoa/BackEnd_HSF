package com.koisystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRoleEnum {
    ROLE_MEMBER(1),
    ROLE_ADMIN(2),
    ROLE_SHOP(3);

    private final int value;
}