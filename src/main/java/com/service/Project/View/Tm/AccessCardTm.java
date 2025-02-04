package com.service.Project.View.Tm;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccessCardTm {
        private String cardId;
        private Date issuetDate ;
        private Date expiryDate ;
        private String custId;
}
