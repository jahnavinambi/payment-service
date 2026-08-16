package com.payment.system.domain;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PaymentRequest {

    @NotNull
    private Integer invoiceId;
    @NotNull
    private Integer customerId;
    private double amount;
    private String currency;
    private PaymentMethod paymentMethod;
}
