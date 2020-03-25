package hr.tvz.antunovic.studapp.entities;

import lombok.Data;

@Data
public class StudentDTO {

    private final String JMBAG;
    private final Integer numberOfECTS;
    private final boolean tuitionShouldBePaid;

}