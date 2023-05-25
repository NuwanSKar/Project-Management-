package com.projectmanagement.PM.entity;

import com.projectmanagement.PM.other.otherClasses.AssignedDutiesEntity;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "project_breakdown")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectBreakDown {
    @Id
    private String breakdownId;
    private String stage;
    private String startDate;
    private String endDate;
    private long Cost;
    private boolean activeStatus;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private ArrayList<AssignedDutiesEntity> assignedDutiesList;

    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private Project projectId;


    @ManyToMany
    @JoinTable(name = "employer_projectbreakdown",
            joinColumns = @JoinColumn(name = "projectbreakdown_id"),
            inverseJoinColumns  = @JoinColumn(name = "employer_id")
    )
    private List<Employer> employers = new ArrayList<>();

}

