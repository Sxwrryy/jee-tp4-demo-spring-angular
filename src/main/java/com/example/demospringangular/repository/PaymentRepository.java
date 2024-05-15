package com.example.demospringangular.repository;
import com.example.demospringangular.entities.Payment;
import com.example.demospringangular.entities.PaymentStatus;
import com.example.demospringangular.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}
