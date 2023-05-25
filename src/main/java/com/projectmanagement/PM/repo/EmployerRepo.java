package com.projectmanagement.PM.repo;

import com.projectmanagement.PM.entity.Employer;
import com.projectmanagement.PM.other.enums.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface EmployerRepo extends JpaRepository<Employer,String> {
    List<Employer> getAllByActiveStatus(boolean b);
    List<Employer> getAllByActiveStatusAndJobType(boolean b, JobType jobType);


    Employer getByEmployerIDAndActiveStatus(String j, boolean b);
}
