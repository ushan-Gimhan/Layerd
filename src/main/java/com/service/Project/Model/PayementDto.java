package com.service.Project.Model;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PayementDto {
    private String payementId;
    private Double payementAmount;
    private LocalDate payementDate;
    private String payementType;
    private String custId;

}
