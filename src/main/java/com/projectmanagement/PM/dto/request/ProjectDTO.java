package com.projectmanagement.PM.dto.request;

import com.projectmanagement.PM.other.enums.ProjectType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDTO {
    private String projectName;
    private ProjectType projectType;
    private String startDate;
    private String deadLine;
    private long price;
    private String client;
    private String note;


}
