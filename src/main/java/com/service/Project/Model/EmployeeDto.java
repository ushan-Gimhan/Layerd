package com.service.Project.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String employeeId;
    private String employeeName;
    private String designation;
    private String email;
    private String phoneNumber;
    private String adminId;

}
