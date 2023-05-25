package com.projectmanagement.PM.service.impl;

import com.projectmanagement.PM.dto.request.EmployerDTO;
import com.projectmanagement.PM.dto.response.GetAllEmployersDTO;
import com.projectmanagement.PM.entity.Employer;
import com.projectmanagement.PM.other.enums.JobType;
import com.projectmanagement.PM.other.mappers.MapStructMapper;
import com.projectmanagement.PM.repo.EmployerRepo;
import com.projectmanagement.PM.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class EmployerServiceIMPL implements EmployerService {
    @Autowired
    private MapStructMapper mapStructMapper;
    @Autowired
    private EmployerRepo employerRepo;

    @Override
    public String addNewEmployer(EmployerDTO employerDTO) {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        int i = Math.abs(random.nextInt()%25);
        String employerId = "EMP" + String.valueOf(year).substring(2)+String.valueOf(employerRepo.count()+1) + alphabet.charAt(i);
        Employer employer = mapStructMapper.employerDTOToEntity(employerDTO);
        employer.setEmployerID(employerId);
        employer.setActiveStatus(true);
        employerRepo.save(employer);
        return employerDTO.getName() + " was added Successfully";
    }

    @Override
    public List<GetAllEmployersDTO> getAllActiveEmployers() {
        List<Employer> employerList = employerRepo.getAllByActiveStatus(true);
        ArrayList<GetAllEmployersDTO> getAllEmployersDTOArrayList = new ArrayList<GetAllEmployersDTO>();
        for(Employer employer: employerList){
            GetAllEmployersDTO getAllEmployersDTO =mapStructMapper.employerEntityToDTO(employer);
            getAllEmployersDTOArrayList.add(getAllEmployersDTO);
        }
        return getAllEmployersDTOArrayList;
    }

    @Override
    public List<GetAllEmployersDTO> getAllActiveEmployersByJobType(JobType jobType) {
        List<Employer> employerList = employerRepo.getAllByActiveStatusAndJobType(true,jobType);
        ArrayList<GetAllEmployersDTO> getAllEmployersDTOArrayList = new ArrayList<GetAllEmployersDTO>();
        for(Employer employer: employerList){
            GetAllEmployersDTO getAllEmployersDTO =mapStructMapper.employerEntityToDTO(employer);
            getAllEmployersDTOArrayList.add(getAllEmployersDTO);
        }
        return getAllEmployersDTOArrayList;
    }

}
