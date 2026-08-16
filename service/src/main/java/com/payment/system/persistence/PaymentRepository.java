package com.payment.system.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    // Implement database operations for payment processing here
    @Query("SELECT p FROM PaymentEntity p WHERE p.idempotencyKey = :idempotencyKey")
    Optional<PaymentEntity> findByIdempotencyKey(String idempotencyKey);


}
