package com.service.Project.View.Tm;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NotificationTm {
        private String id;
        private String massege;
        private Date date;
        private String custId;
        private String empId;
}
