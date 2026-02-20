package WWSIS.repository;

import WWSIS.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
    Student findByNrIndeksu(String nrIndeksu);
}