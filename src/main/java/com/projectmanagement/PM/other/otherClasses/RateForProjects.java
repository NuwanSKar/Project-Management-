package com.projectmanagement.PM.other.otherClasses;
import com.projectmanagement.PM.other.enums.RateType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RateForProjects {
    private String description;
    private long rate;
    private RateType rateType;
}
