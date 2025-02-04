package com.service.Project.Model;

import lombok.*;

@Getter
@NoArgsConstructor
@Setter
@ToString
@AllArgsConstructor
public class AdminDto {
    private String adminId;
    private String adminName;
    private String email;
    private String mobileNumber;
    private String adminPassword;
}
