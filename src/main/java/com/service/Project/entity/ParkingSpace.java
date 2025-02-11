package com.service.Project.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParkingSpace {
    private String spaceId;
    private String floorId;
    private String status;
}
