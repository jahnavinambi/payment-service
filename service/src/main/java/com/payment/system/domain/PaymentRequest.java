package com.payment.system.domain;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    @NotNull
    private Integer invoiceId;
    @NotNull
    private Integer customerId;
    private double amount;
    private String currency;
    private PaymentMethod paymentMethod;
}
