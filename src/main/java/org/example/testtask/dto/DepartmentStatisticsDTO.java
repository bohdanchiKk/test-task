package org.example.testtask.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentStatisticsDTO {

    private long assistants;
    private long associateProfessors;
    private long professors;

    public DepartmentStatisticsDTO(long assistants, long associateProfessors, long professors) {
        this.assistants = assistants;
        this.associateProfessors = associateProfessors;
        this.professors = professors;
    }

}
