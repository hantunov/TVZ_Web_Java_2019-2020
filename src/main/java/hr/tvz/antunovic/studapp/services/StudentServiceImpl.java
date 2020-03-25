package hr.tvz.antunovic.studapp.services;

import hr.tvz.antunovic.studapp.entities.Student;
import hr.tvz.antunovic.studapp.entities.StudentDTO;
import hr.tvz.antunovic.studapp.repositories.StudentRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class StudentServiceImpl implements StudentService {

    private static final int YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAID = 26;
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentByJMBAG(String JMBAG) {
        return studentRepository.findStudentByJMBAG(JMBAG).map(this::mapStudentToDTO).orElse(null);
    }

    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(student.getJMBAG(), student.getNumberOfECTS(), shouldTuitionBePaid(student.getDateOfBirth()));
    }

    private boolean shouldTuitionBePaid(LocalDate dateOfBirth){
        return dateOfBirth.plusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAID).isBefore(LocalDate.now());
    }
}
