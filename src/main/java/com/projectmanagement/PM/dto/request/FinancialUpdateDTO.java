package com.projectmanagement.PM.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FinancialUpdateDTO {
    private String projectId;
    private long price;
    private long totalCost;
}
