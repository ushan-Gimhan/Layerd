package com.service.Project.Model;


import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InsidentDto {
    private String insidentId;
    private String insidentName;
    private Date insidentDate;
    private Time insidentTime;
    private int floorId;
}
