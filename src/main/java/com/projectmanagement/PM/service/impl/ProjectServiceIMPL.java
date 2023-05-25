package com.projectmanagement.PM.service.impl;

import com.projectmanagement.PM.dto.request.FinancialUpdateDTO;
import com.projectmanagement.PM.dto.request.ProjectBreakDownDTO;
import com.projectmanagement.PM.dto.request.ProjectDTO;
import com.projectmanagement.PM.dto.response.GetProjectDetailsByIDDTO;
import com.projectmanagement.PM.entity.Employer;
import com.projectmanagement.PM.entity.Project;
import com.projectmanagement.PM.entity.ProjectBreakDown;
import com.projectmanagement.PM.other.enums.ProjectStatus;
import com.projectmanagement.PM.other.mappers.MapStructMapper;
import com.projectmanagement.PM.other.otherClasses.AssignedDuties;
import com.projectmanagement.PM.other.otherClasses.ProjectBreakDownResponse;
import com.projectmanagement.PM.repo.EmployerRepo;
import com.projectmanagement.PM.repo.ProjectBreakDownRepo;
import com.projectmanagement.PM.repo.ProjectRepo;
import com.projectmanagement.PM.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


@Service
public class ProjectServiceIMPL implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private ProjectBreakDownRepo projectBreakDownRepo;
    @Autowired
    private MapStructMapper mapStructMapper;
    @Autowired
    private EmployerRepo employerRepo;

    @Override
    public String addNewProject(ProjectDTO projectDTO) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        String projectId = "PRJ" + String.valueOf(year).substring(2) + (projectRepo.count()+1) ;

        Project project = mapStructMapper.projectDTOToEntity(projectDTO);
        project.setProjectId(projectId);
        project.setActiveStatus(true);
        projectRepo.save(project);
        return "Project added successfully";
    }

    @Override
    public String addNewProjectBreakdown(ProjectBreakDownDTO projectBreakDownDTO) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        String breakdownId = "PBD" + String.valueOf(year).substring(2) + (projectBreakDownRepo.count()+1) ;

        ProjectBreakDown projectBreakDown = mapStructMapper.projectBreakDownDTOToEntity(projectBreakDownDTO);
        projectBreakDown.setProjectId(projectRepo.getByProjectId(projectBreakDownDTO.getProjId()));
        projectBreakDown.setBreakdownId(breakdownId);
        projectBreakDown.setActiveStatus(true);
        if (!(projectRepo.getByProjectId(projectBreakDownDTO.getProjId()).isActiveStatus())){
            projectBreakDown.setActiveStatus(false);
        }

        List<Employer> employerList = new ArrayList<>();
        for (AssignedDuties i: projectBreakDownDTO.getAssignedDutiesList()){
            for(String j : i.getAssignedPersons()){
                Employer employer = employerRepo.getByEmployerIDAndActiveStatus(j, true);
                employerList.add(employer) ;
            }
            projectBreakDown.setEmployers(employerList);
        }

        projectBreakDownRepo.save(projectBreakDown);
        return "Project breakdown added successfully";
    }

    @Override
    public GetProjectDetailsByIDDTO getProjectDetails(String projectId) {
        Project project = projectRepo.getByProjectId(projectId);
        List<ProjectBreakDown> projectBreakDown = projectBreakDownRepo.getAllByProjectId(project);
        GetProjectDetailsByIDDTO getProjectDetailsByIDDTO = mapStructMapper.projectEntityToGetProjectDetailsByIDDTO(project);
        List<ProjectBreakDownResponse> projectBreakDownResponses = mapStructMapper.projectBreakDownTOProjectBreakDownResponse(projectBreakDown);
        getProjectDetailsByIDDTO.setProjectBreakDownResponses(projectBreakDownResponses);
        return getProjectDetailsByIDDTO;
    }

    @Override
    public String updateProjectFinancial(FinancialUpdateDTO financialUpdateDTO) {
        Project project = projectRepo.getByProjectId(financialUpdateDTO.getProjectId());
        project.setTotalCost(financialUpdateDTO.getTotalCost());
        project.setPrice(financialUpdateDTO.getPrice());
        projectRepo.save(project);
        return "Updated successfully";
    }

    @Override
    public List<GetProjectDetailsByIDDTO> getAllProjectsByStatus(ProjectStatus projectStatus) {
        List<Project> project ;
        if(projectStatus == ProjectStatus.ALL){
            project = projectRepo.findAll();
        }
        else{
            boolean status = true ;
            if (projectStatus == ProjectStatus.INACTIVE){
                status = false;
            }
            project = projectRepo.getAllByActiveStatus(status);
        }
        List<GetProjectDetailsByIDDTO> getProjectDetailsByIDDTOS = new ArrayList<>();
        for (Project i : project){
            GetProjectDetailsByIDDTO getProjectDetailsByIDDTO = mapStructMapper.projectEntityToGetProjectDetailsByIDDTO(i);
            List<ProjectBreakDown> projectBreakDown = projectBreakDownRepo.getAllByProjectId(i);
            List<ProjectBreakDownResponse> projectBreakDownResponses = mapStructMapper.projectBreakDownTOProjectBreakDownResponse(projectBreakDown);
            getProjectDetailsByIDDTO.setProjectBreakDownResponses(projectBreakDownResponses);
            getProjectDetailsByIDDTOS.add(getProjectDetailsByIDDTO);
        }
        return getProjectDetailsByIDDTOS;
    }

    @Override
    public String projectStatusUpdate(boolean status, String projectID) {
        Project project = projectRepo.getByProjectId(projectID);
        project.setActiveStatus(status);
        if (!status){
            List<ProjectBreakDown> projectBreakDown = projectBreakDownRepo.getAllByProjectId(project);
            for (ProjectBreakDown i: projectBreakDown){
                i.setActiveStatus(false);
                projectBreakDownRepo.save(i);
            }
        }
        projectRepo.save(project);
        return "Status updated successfully";
    }

}
