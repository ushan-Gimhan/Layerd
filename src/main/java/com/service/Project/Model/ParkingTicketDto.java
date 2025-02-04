package com.service.Project.Model;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParkingTicketDto {
    private String ticketId;
    private Date parkingTime;
    private String resId;
    private String vechicleId;
}
