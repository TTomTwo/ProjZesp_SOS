package WWSIS.dao;

import WWSIS.entity.Student;
import java.util.List;

public interface StudentDao {

    // Pobierz studenta po ID
    Student pobierzStudenta(Integer id);

    // Pobierz studenta po emailu (np. do logowania)
    Student pobierzStudentaPoEmailu(String email);

    // Pobierz studenta po numerze indeksu
    Student pobierzStudentaPoIndeksie(String nrIndeksu);

    // Pobierz wszystkich studentów
    List<Student> pobierzWszystkichStudentow();

    // Zapisz lub zaktualizuj studenta
    void zapiszStudenta(Student student);

    // Usuń studenta
    void usunStudenta(Integer id);

    // Zmień hasło studenta
    void zmienHaslo(Integer studentId, String noweHasloHash);
}