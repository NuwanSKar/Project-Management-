package com.projectmanagement.PM.other.mappers;

import com.projectmanagement.PM.dto.request.EmployerDTO;
import com.projectmanagement.PM.dto.request.ProjectBreakDownDTO;
import com.projectmanagement.PM.dto.request.ProjectDTO;
import com.projectmanagement.PM.dto.response.GetAllEmployersDTO;
import com.projectmanagement.PM.dto.response.GetProjectDetailsByIDDTO;
import com.projectmanagement.PM.entity.Employer;
import com.projectmanagement.PM.entity.Project;
import com.projectmanagement.PM.entity.ProjectBreakDown;
import com.projectmanagement.PM.other.otherClasses.ProjectBreakDownResponse;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface MapStructMapper {
    Employer employerDTOToEntity(EmployerDTO employerDTO);
    GetAllEmployersDTO employerEntityToDTO(Employer employer);
    Project projectDTOToEntity(ProjectDTO projectDTO);
    ProjectBreakDown projectBreakDownDTOToEntity(ProjectBreakDownDTO projectBreakDownDTO);
    GetProjectDetailsByIDDTO projectEntityToGetProjectDetailsByIDDTO(Project project);
    List<ProjectBreakDownResponse> projectBreakDownTOProjectBreakDownResponse(List<ProjectBreakDown> projectBreakDown);
}
