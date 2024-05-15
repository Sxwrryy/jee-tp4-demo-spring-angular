package com.example.demospringangular.dtos;

import com.example.demospringangular.entities.PaymentStatus;
import com.example.demospringangular.entities.PaymentType;
import com.example.demospringangular.entities.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor @Getter
@Setter
@ToString @Builder
public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private Double amount;
    private PaymentType type;
    private PaymentStatus status;
}
