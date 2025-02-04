package com.service.Project.View.Tm;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentTm {
        private String payementId;
        private Double payementAmount;
        private Date payementDate;
        private String payementType;
        private String custId;

}
