package com.service.Project.entity;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AllReservation {
    private String reservationId;
    private String customerId;
    private String lotId;
    private String floorId;
    private String spaceId;
    private Date reservationDate;
    private Date endDate;
    private Time startTime;
    private Time  endTime;
    private String customerName;
    private Double amount;
}
