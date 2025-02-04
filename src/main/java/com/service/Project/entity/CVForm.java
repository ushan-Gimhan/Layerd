package com.service.Project.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CVForm {
    private String customerId;
    private String name;
    private String NIC;
    private String email;
    private String phone;
    private String vehicleNumber;
    private String vehicleCategory;
    private Double pricePerHourse;
}
