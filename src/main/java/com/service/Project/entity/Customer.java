package com.service.Project.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer{
    private String customerId;
    private String name;
    private String NIC;
    private String email;
    private String phone;

}
