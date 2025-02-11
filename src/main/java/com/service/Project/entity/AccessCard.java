package com.service.Project.entity;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccessCard {
    private String cardId;
    private Date issuetDate ;
    private Date expiryDate ;
    private String custId;
}
