package com.projectmanagement.PM.other.otherClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssignedDutiesEntity {
    private String duty;
    private List<String> assignedPersons;  //get employers from database , make this a set instead of list and map
    private String note;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "projectBreakDowns")
//    private Set<Employer> assignedEmployers = new HashSet<>();

}
