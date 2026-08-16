package com.payment.system.domain;

import jakarta.validation.constraints.NotNull;

public class PaymentResponse {
    @NotNull
    private Integer invoiceId;
    @NotNull
    private Integer customerId;
    private double amount;
    private String currency;
    private PaymentMethod paymentMethod;
    private String status;
    private String transactionId;
    private String date;
}