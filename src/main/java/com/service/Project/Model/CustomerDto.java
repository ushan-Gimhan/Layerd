package com.service.Project.Model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String customerId;
    private String name;
    private String NIC;
    private String email;
    private String phone;
}

