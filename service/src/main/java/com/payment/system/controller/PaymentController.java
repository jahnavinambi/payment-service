package com.payment.system.controller;

import com.payment.system.domain.PaymentRequest;
import com.payment.system.domain.PaymentRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/api/v1/payments")
    public void performPayment(@RequestBody PaymentRequest paymentDetails){

        // Implement payment processing logic here


    }

}
