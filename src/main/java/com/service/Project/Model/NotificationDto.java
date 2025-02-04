package com.service.Project.Model;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDto {
    private String id;
    private String massege;
    private Date date;
    private String custId;
    private String empId;
}
