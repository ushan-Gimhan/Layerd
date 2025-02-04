package com.service.Project.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private String payementId;
    private Double payementAmount;
    private Date payementDate;
    private String payementType;
    private String custId;
}
