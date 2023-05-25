package com.projectmanagement.PM.entity;

import com.projectmanagement.PM.other.enums.JobType;
import com.projectmanagement.PM.other.enums.WorkingSection;
import com.projectmanagement.PM.other.otherClasses.AssignedDutiesEntity;
import com.projectmanagement.PM.other.otherClasses.Portfolio;
import com.projectmanagement.PM.other.otherClasses.RateForProjects;
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
@Table(name ="employer_details")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employer {
    @Id
    @Column(name = "employer_id", nullable = false)
    private String employerID;
    private String name;
    private int age;
    private String phoneNo;
    private String address;
    private String country;
//    private String position;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<String> socialMediaLinks;

    private String description;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<Portfolio> portfolio;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Enumerated(EnumType.STRING)
    private WorkingSection workingSection;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<RateForProjects> rate;

    private boolean activeStatus;

    @JsonIgnore
    @ManyToMany(mappedBy = "employers")
//    @JoinTable(name = "employer_projectbreakdown",
//            joinColumns = @JoinColumn(name = "employer_id"),
//            inverseJoinColumns = @JoinColumn(name = "projectbreakdown_id")
//    )
    private List<ProjectBreakDown> projectBreakDowns = new ArrayList<>();

}
