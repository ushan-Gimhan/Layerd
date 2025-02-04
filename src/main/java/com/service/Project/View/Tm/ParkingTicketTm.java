package com.service.Project.View.Tm;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParkingTicketTm {
        private String ticketId;
        private Date parkingTime;
        private String resId;
        private String vechicleId;

}
