package com.projectmanagement.PM.dto.response;

import com.projectmanagement.PM.entity.ProjectBreakDown;
import com.projectmanagement.PM.other.enums.ProjectType;
import com.projectmanagement.PM.other.otherClasses.ProjectBreakDownResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetProjectDetailsByIDDTO {
    private String projectName;
    private ProjectType projectType;
    private String startDate;
    private String deadLine;
    private String finishedDate;
    private String client;
    private String note;
    private long price;
    private long totalCost;
    private List<ProjectBreakDownResponse> projectBreakDownResponses;
}
