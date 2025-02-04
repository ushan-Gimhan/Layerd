package com.service.Project.Model;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResavationDto {
    private String resId;
    private LocalTime startTime;
    private LocalTime endTime;
    private String custId;
    private String spaceId;
    private LocalDate resDate;
    private LocalDate endDate;
    private double price;

}
