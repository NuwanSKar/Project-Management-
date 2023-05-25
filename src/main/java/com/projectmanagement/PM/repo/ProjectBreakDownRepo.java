package com.projectmanagement.PM.repo;

import com.projectmanagement.PM.entity.Project;
import com.projectmanagement.PM.entity.ProjectBreakDown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProjectBreakDownRepo extends JpaRepository<ProjectBreakDown,String> {
    List<ProjectBreakDown> getAllByProjectId(Project project);
}
