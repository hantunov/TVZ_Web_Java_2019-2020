package hr.tvz.antunovic.studapp.repositories;

import java.util.List;
import java.util.Optional;
import hr.tvz.antunovic.studapp.entities.Student;

public interface StudentRepository {

    List<Student> findAll();

    Optional<Student> findStudentByJMBAG(String JMBAG);

}
