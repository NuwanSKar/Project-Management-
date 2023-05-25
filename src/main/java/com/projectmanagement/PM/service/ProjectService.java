package com.projectmanagement.PM.service;

import com.projectmanagement.PM.dto.request.FinancialUpdateDTO;
import com.projectmanagement.PM.dto.request.ProjectBreakDownDTO;
import com.projectmanagement.PM.dto.request.ProjectDTO;
import com.projectmanagement.PM.dto.response.GetProjectDetailsByIDDTO;
import com.projectmanagement.PM.other.enums.ProjectStatus;

import java.util.List;

public interface ProjectService {
    String addNewProject(ProjectDTO projectDTO);
    String addNewProjectBreakdown(ProjectBreakDownDTO projectBreakDownDTO);
    GetProjectDetailsByIDDTO getProjectDetails(String projectId);
    String updateProjectFinancial(FinancialUpdateDTO financialUpdateDTO);
    List<GetProjectDetailsByIDDTO> getAllProjectsByStatus(ProjectStatus projectStatus);
    String projectStatusUpdate(boolean status, String projectID);
}
