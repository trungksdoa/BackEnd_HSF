package com.koisystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentCode {
    PENDING("PENDING"),
    PAID("PAID"),
    FAILED("FAILED");

    private String value;


}
