package com.service.Project.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer{
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;

}
