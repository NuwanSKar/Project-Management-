package com.projectmanagement.PM.controller;

import com.projectmanagement.PM.dto.request.FinancialUpdateDTO;
import com.projectmanagement.PM.dto.request.ProjectBreakDownDTO;
import com.projectmanagement.PM.dto.request.ProjectDTO;
import com.projectmanagement.PM.dto.response.GetProjectDetailsByIDDTO;
import com.projectmanagement.PM.other.enums.ProjectStatus;
import com.projectmanagement.PM.other.responseEntity.StandardResponse;
import com.projectmanagement.PM.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/employer")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(path = "/add-new-project")
    public ResponseEntity<StandardResponse> addNewProject(@RequestBody ProjectDTO projectDTO){
        String message = projectService.addNewProject(projectDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Successful", message), HttpStatus.CREATED);
    }

    @PostMapping(path = "/add-project-breakdown")
    public ResponseEntity<StandardResponse> addProjectBreakDown(@RequestBody ProjectBreakDownDTO projectBreakDownDTO){
        String message = projectService.addNewProjectBreakdown(projectBreakDownDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Successful", message), HttpStatus.OK);
    }

    @GetMapping(path = "/get-project/{projectId}")
    public ResponseEntity<StandardResponse> getProjectDetails(@PathVariable(value = "projectId") String projectId){
        GetProjectDetailsByIDDTO message = projectService.getProjectDetails(projectId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successful", message), HttpStatus.OK);
    }

    @PutMapping(path = "/project-financial")
    public ResponseEntity<StandardResponse> updateProjectFinancial(@RequestBody FinancialUpdateDTO financialUpdateDTO){
        String message = projectService.updateProjectFinancial(financialUpdateDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successful", message), HttpStatus.OK);
    }

    @GetMapping(path = "/get-all-projects/{status}")
    public ResponseEntity<StandardResponse> getAllProjectsByStatus(@PathVariable(value = "status") ProjectStatus projectStatus){
        List<GetProjectDetailsByIDDTO> message = projectService.getAllProjectsByStatus(projectStatus);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Successful", message), HttpStatus.OK);
    }

    @PutMapping(path = "/project-status-update/{status}")
    public ResponseEntity<StandardResponse> projectStatusUpdate(@PathVariable(value = "status")boolean status, String projectID){
        String message = projectService.projectStatusUpdate(status,projectID);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Successful", message), HttpStatus.OK);
    }

}





// ***   edit project separately (breakdown, main details, financial);
