package com.payment.system.domain;

import lombok.Data;

public enum PaymentMethod {
    CARD("card"),
    BANK_TRANSFER("bank_transfer"),
    PAYPAL("paypal"),
    CRYPTOCURRENCY("cryptocurrency"),
    APPLE_PAY("apple_pay");

    private final String value;

    PaymentMethod(String value) {
        this.value = value;
    }
}
