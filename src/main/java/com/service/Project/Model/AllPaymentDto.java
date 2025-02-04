package com.service.Project.Model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AllPaymentDto {
    private String paymentId;
    private String reservationId;
    private double amount;
    private String paymentDate;
    private String paymentMethod;
    private String customerName;
}
