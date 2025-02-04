package com.service.Project.View.Tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AllPayemntTm{
    private String paymentId;
    private String reservationId;
    private double amount;
    private String paymentDate;
    private String paymentMethod;
    private String customerName;
}
