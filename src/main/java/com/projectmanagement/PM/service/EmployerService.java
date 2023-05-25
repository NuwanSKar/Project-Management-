package com.projectmanagement.PM.service;

import com.projectmanagement.PM.dto.request.EmployerDTO;
import com.projectmanagement.PM.dto.response.GetAllEmployersDTO;
import com.projectmanagement.PM.other.enums.JobType;

import java.util.List;

public interface EmployerService {
    String addNewEmployer(EmployerDTO employerDTO);
    List<GetAllEmployersDTO> getAllActiveEmployers();
    List<GetAllEmployersDTO> getAllActiveEmployersByJobType(JobType jobType);
}
