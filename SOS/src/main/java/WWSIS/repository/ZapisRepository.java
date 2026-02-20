package WWSIS.repository;

import WWSIS.entity.Zapis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZapisRepository extends JpaRepository<Zapis, Integer> {

    // JpaRepository zapewnia wszystkie podstawowe operacje CRUD (Create, Read, Update, Delete) dla encji Zapis
    // Nie musimy implementować metod do takich operacji, ponieważ JpaRepository to robi automatycznie.

    // Jeśli chcesz dodać niestandardowe zapytania, można je dodać tutaj,
    // na przykład: findByStudentId(Integer studentId), findByGrupaId(Integer grupaId), itd.

}