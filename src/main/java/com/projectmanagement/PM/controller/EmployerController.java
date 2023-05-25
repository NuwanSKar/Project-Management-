package com.projectmanagement.PM.controller;

import com.projectmanagement.PM.dto.request.EmployerDTO;
import com.projectmanagement.PM.dto.response.GetAllEmployersDTO;
import com.projectmanagement.PM.other.enums.JobType;
import com.projectmanagement.PM.other.responseEntity.StandardResponse;
import com.projectmanagement.PM.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/employer")
@CrossOrigin
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @PostMapping(path = "/add-new-employer")
    public ResponseEntity<StandardResponse> addNewEmployer(@RequestBody EmployerDTO employerDTO){
        String message= employerService.addNewEmployer(employerDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(204, "Successful", message), HttpStatus.CREATED);
        return response ;
    }

    @GetMapping(path = "/get-all-employers")
    public ResponseEntity<StandardResponse> getAllEmployers(){
        List<GetAllEmployersDTO> message =employerService.getAllActiveEmployers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successful", message), HttpStatus.OK);
    }

    @GetMapping(path = "/get-all-employers/{jobType}")
    public ResponseEntity<StandardResponse> getAllEmployersByJobType(@PathVariable(value = "jobType") JobType jobType){
        List<GetAllEmployersDTO> message =employerService.getAllActiveEmployersByJobType(jobType);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Successful", message), HttpStatus.OK);
    }

}




// **** include edit employers; filter employers(by department of working);

