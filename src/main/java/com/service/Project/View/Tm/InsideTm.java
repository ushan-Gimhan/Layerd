package com.service.Project.View.Tm;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InsideTm {
        private String insidentId;
        private String insidentName;
        private Date insidentDate;
        private Time insidentTime;
        private int floorId;
}
