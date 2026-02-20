package WWSIS.repository;

import WWSIS.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    /**
     * Metoda do wyszukiwania studenta na podstawie jego adresu e-mail.
     * Spring Data JPA automatycznie generuje zapytanie na podstawie nazwy metody.
     * @param email adres e-mail studenta
     * @return Student obiekt studenta lub null, jeśli student o podanym e-mailu nie istnieje
     */
    Student findByEmail(String email);

    /**
     * Metoda do wyszukiwania studenta na podstawie jego numeru indeksu.
     * Spring Data JPA automatycznie generuje zapytanie na podstawie nazwy metody.
     * @param nrIndeksu numer indeksu studenta
     * @return Student obiekt studenta lub null, jeśli student o podanym numerze indeksu nie istnieje
     */
    Student findByNrIndeksu(String nrIndeksu);
}