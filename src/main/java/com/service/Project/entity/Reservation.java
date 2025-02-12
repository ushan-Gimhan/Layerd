package com.service.Project.entity;

import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    private String resId;
    private LocalTime startTime;
    private LocalTime endTime;
    private String custId;
    private String spaceId;
    private LocalDate resDate;
    private LocalDate endDate;
    private double price;

}
