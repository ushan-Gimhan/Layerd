package com.service.Project.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AllPayment {
    private String paymentId;
    private String reservationId;
    private double amount;
    private String paymentDate;
    private String paymentMethod;
    private String customerName;
}
