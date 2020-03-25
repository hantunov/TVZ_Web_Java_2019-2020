package hr.tvz.antunovic.studapp.repositories;

import hr.tvz.antunovic.studapp.entities.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class MockStudentRepository implements StudentRepository {

    private final List<Student> MOCKED_STUDENTS = Arrays.asList(
            new Student("Ivo", "Ivić", "0256423323", LocalDate.now().minusYears(27), 120),
            new Student("Lucija", "Lucić", "0256423324", LocalDate.now().minusYears(25), 98)
    );

    @Override
    public List<Student> findAll() {
        return MOCKED_STUDENTS;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(final String JMBAG) {
        return MOCKED_STUDENTS.stream().filter(it -> Objects.equals(it.getJMBAG(), JMBAG)).findAny();
    }
}
