package com.service.Project.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String employeeId;
    private String employeeName;
    private String designation;
    private String email;
    private String phoneNumber;
    private String adminId;
}
