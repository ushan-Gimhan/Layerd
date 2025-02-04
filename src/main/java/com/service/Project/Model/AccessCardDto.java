package com.service.Project.Model;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccessCardDto {
    private String cardId;
    private Date issuetDate ;
    private Date expiryDate ;
    private String custId;
}
