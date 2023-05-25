package com.projectmanagement.PM.entity;

import com.projectmanagement.PM.other.enums.ProjectType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project_details")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project {
    @Id
    @Column(nullable = false)
    private String projectId;
    private String projectName;
    @Enumerated(EnumType.STRING)
    private ProjectType projectType;
    private String startDate;
    private String deadLine;
    private String finishedDate;
    private String client;
    private String note;
    private long price;
    private long totalCost;
    private boolean activeStatus;

    @OneToMany(mappedBy="projectId")
    private Set<ProjectBreakDown> projectBreakDowns;


}
