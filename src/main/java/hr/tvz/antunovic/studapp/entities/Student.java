package hr.tvz.antunovic.studapp.entities;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Student {

    private final String name;
    private final String surname;
    private final String JMBAG;
    private final LocalDate dateOfBirth;
    private final Integer numberOfECTS;

}