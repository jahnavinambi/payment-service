package com.payment.system.domain;

public enum PaymentStatus {

    PENDING("Pending"),
    SUCCESS("Success"),
    FAILED("Failed");

    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }
}
