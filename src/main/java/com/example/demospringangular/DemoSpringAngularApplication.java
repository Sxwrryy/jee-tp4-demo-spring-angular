package com.example.demospringangular;

import com.example.demospringangular.entities.Payment;
import com.example.demospringangular.entities.PaymentStatus;
import com.example.demospringangular.entities.PaymentType;
import com.example.demospringangular.entities.Student;
import com.example.demospringangular.repository.PaymentRepository;
import com.example.demospringangular.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class DemoSpringAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringAngularApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
                                        PaymentRepository paymentRepository) {
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Mohamed").code("12343").programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Malak").code("12987").programId("SDIA")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Imane").code("12753").programId("GLICD")
                    .build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString())
                    .firstName("Najat").code("17843").programId("BDDC")
                    .build());

            PaymentType[] paymentTypes = PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(st->{
                    for (int i=0; i < 10; i++) {
                        int index = random.nextInt(paymentTypes.length);
                        Payment payment = Payment.builder()
                                .amount(1000+(double)(Math.random()+20000))
                                .type(paymentTypes[index])
                                .status(PaymentStatus.CREATED)
                                .date(LocalDate.now())
                                .student(st)
                                .build();
                        paymentRepository.save(payment);
                    }

            });
        };
    }
}
