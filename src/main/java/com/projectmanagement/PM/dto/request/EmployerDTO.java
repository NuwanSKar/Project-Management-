package com.projectmanagement.PM.dto.request;

import com.projectmanagement.PM.other.enums.JobType;
import com.projectmanagement.PM.other.enums.WorkingSection;
import com.projectmanagement.PM.other.otherClasses.Portfolio;
import com.projectmanagement.PM.other.otherClasses.RateForProjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployerDTO {
    private String name;
    private int age;
    private String phoneNo;
    private String address;
    private String country;
    private List<String> socialMediaLinks;
    private String description;
    private List<Portfolio> portfolio;
    private JobType jobType;
    private WorkingSection workingSection;
    private List<RateForProjects> rate;
}
