package com.service.Project.Model;

import lombok.*;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CvFormDto {
        private String customerId;
        private String name;
        private String NIC;
        private String email;
        private String phone;
        private String vehicleNumber;
        private String vehicleCategory;
        private Double pricePerHourse;
}
