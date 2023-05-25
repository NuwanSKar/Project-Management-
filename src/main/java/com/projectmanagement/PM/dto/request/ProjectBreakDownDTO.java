package com.projectmanagement.PM.dto.request;

import com.projectmanagement.PM.other.otherClasses.AssignedDuties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectBreakDownDTO {
    private String projId;
    private String stage;
    private String startDate;
    private String endDate;
    private long Cost;
    private ArrayList<AssignedDuties> assignedDutiesList;

}
