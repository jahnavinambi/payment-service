package com.payment.system.service;

import com.payment.system.domain.PaymentRequest;
import com.payment.system.domain.PaymentResponse;
import com.payment.system.persistence.PaymentEntity;
import com.payment.system.persistence.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    public PaymentResponse processPayment(PaymentRequest paymentRequest, String idempotencyKey) {
        // Implement payment processing logic here
        Optional<PaymentEntity> existingPayment =
                paymentRepository.findByIdempotencyKey(idempotencyKey);
        PaymentEntity paymentEntity;
        if(existingPayment.isPresent()) {
            // Return existing payment details if the idempotency key already exists
            paymentEntity = existingPayment.get();
            log.info("Payment already processed for idempotency key: {}", idempotencyKey);
        }
        else{
            // Process the payment and save the details to the database
            paymentEntity = new PaymentEntity(
                    java.util.UUID.randomUUID(),
                    paymentRequest.getInvoiceId(),
                    paymentRequest.getCustomerId(),
                    java.math.BigDecimal.valueOf(paymentRequest.getAmount()),
                    paymentRequest.getCurrency(),
                    paymentRequest.getPaymentMethod(),
                    com.payment.system.domain.PaymentStatus.SUCCESS,
                    idempotencyKey,
                    java.time.LocalDateTime.now(), java.time.LocalDateTime.now()
            );
            log.info("Processing payment for invoiceId : {}", paymentRequest.getInvoiceId());

            paymentRepository.save(paymentEntity);
        }
        return new PaymentResponse(
                paymentEntity.getInvoiceId(),
                paymentEntity.getCustomerId(),
                paymentEntity.getAmount().doubleValue(),
                paymentEntity.getCurrency(),
                paymentEntity.getPaymentMethod(),
                paymentEntity.getStatus().name(),
                paymentEntity.getCreatedAt()
        );
    }
}
