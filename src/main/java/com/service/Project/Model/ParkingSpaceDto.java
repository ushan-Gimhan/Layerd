package com.service.Project.Model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpaceDto {
    private String spaceId;
    private String status;
    private String floorId;
}
