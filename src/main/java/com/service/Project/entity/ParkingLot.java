package com.service.Project.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParkingLot {
    private String lotId;
    private String location;
    private String status;
}
