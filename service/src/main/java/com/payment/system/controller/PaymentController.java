package com.payment.system.controller;

import com.payment.system.domain.PaymentRequest;
import com.payment.system.domain.PaymentRequest;
import com.payment.system.domain.PaymentResponse;
import com.payment.system.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/api/v1/payments")
    public PaymentResponse performPayment(@RequestBody PaymentRequest paymentRequest,
                                          @RequestHeader(value = "Idempotency-key", required = true) String idempotencyKey) {

        // Implement payment processing logic here
        return paymentService.processPayment(paymentRequest, idempotencyKey);

    }

}
