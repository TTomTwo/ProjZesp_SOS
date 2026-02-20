package WWSIS.service;

import WWSIS.entity.Student;
import WWSIS.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student zapiszStudenta(Student student) {
        return studentRepository.save(student);
    }

    public Student znajdzPoEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}