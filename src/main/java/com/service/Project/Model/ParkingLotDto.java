package com.service.Project.Model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotDto {
    private String lotId;
    private String location;
    private String status;
}
