package hr.tvz.antunovic.studapp.services;

import java.util.List;
import hr.tvz.antunovic.studapp.entities.StudentDTO;

public interface StudentService {

    List<StudentDTO> findAll();

    StudentDTO findStudentByJMBAG(String JMBAG);

}
