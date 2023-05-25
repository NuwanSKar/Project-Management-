package com.projectmanagement.PM.repo;

import com.projectmanagement.PM.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProjectRepo extends JpaRepository<Project,String> {
    Project getByProjectId(String projId);
    List<Project> getAllByActiveStatus(boolean status);
}
