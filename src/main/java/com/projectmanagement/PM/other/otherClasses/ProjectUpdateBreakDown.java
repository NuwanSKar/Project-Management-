package com.projectmanagement.PM.other.otherClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectUpdateBreakDown {
    private String stage;
    private String startDate;
    private String endDate;
    private ArrayList<ArrayList<ArrayList<AssignedDuties>>> assignedDutiesList;
}
