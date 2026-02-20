package WWSIS.dao.impl;

import WWSIS.dao.StudentDao;
import WWSIS.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository // Adnotacja wskazująca, że jest to klasa repozytorium
@Transactional // Adnotacja zapewniająca zarządzanie transakcjami – operacje na bazie będą wykonywane w ramach jednej transakcji
public class StudentDaoImpl implements StudentDao {

    // Wstrzykiwanie EntityManager, który będzie używany do operacji na bazie danych
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Pobiera studenta na podstawie jego identyfikatora.
     *
     * @param id identyfikator studenta
     * @return Student obiekt studenta lub null, jeśli student o danym ID nie istnieje
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu StudentDao
    public Student pobierzStudenta(Integer id) {
        // Znajdujemy studenta po ID w bazie danych
        return entityManager.find(Student.class, id);
    }

    /**
     * Pobiera studenta na podstawie jego adresu e-mail.
     *
     * @param email adres e-mail studenta
     * @return Student obiekt studenta lub null, jeśli student o podanym e-mailu nie istnieje
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu StudentDao
    public Student pobierzStudentaPoEmailu(String email) {
        // Tworzymy zapytanie JPQL do pobrania studenta na podstawie jego adresu e-mail
        Query query = entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.email = :email");
        query.setParameter("email", email); // Ustawiamy parametr email
        List<Student> wyniki = query.getResultList(); // Zwracamy wyniki zapytania
        return wyniki.isEmpty() ? null : wyniki.get(0); // Jeśli nie ma wyników, zwróć null, w przeciwnym razie pierwszy wynik
    }

    /**
     * Pobiera studenta na podstawie jego numeru indeksu.
     *
     * @param nrIndeksu numer indeksu studenta
     * @return Student obiekt studenta lub null, jeśli student o podanym numerze indeksu nie istnieje
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu StudentDao
    public Student pobierzStudentaPoIndeksie(String nrIndeksu) {
        // Tworzymy zapytanie JPQL do pobrania studenta na podstawie jego numeru indeksu
        Query query = entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.nrIndeksu = :nrIndeksu");
        query.setParameter("nrIndeksu", nrIndeksu); // Ustawiamy parametr nrIndeksu
        List<Student> wyniki = query.getResultList(); // Zwracamy wyniki zapytania
        return wyniki.isEmpty() ? null : wyniki.get(0); // Jeśli nie ma wyników, zwróć null, w przeciwnym razie pierwszy wynik
    }

    /**
     * Pobiera listę wszystkich studentów.
     *
     * @return Lista wszystkich studentów
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu StudentDao
    public List<Student> pobierzWszystkichStudentow() {
        // Tworzymy zapytanie JPQL do pobrania wszystkich studentów
        Query query = entityManager.createQuery("SELECT s FROM Student s");
        return query.getResultList(); // Zwracamy listę wyników
    }

    /**
     * Zapisuje nowego studenta do bazy danych.
     *
     * @param student obiekt studenta do zapisania
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu StudentDao
    public void zapiszStudenta(Student student) {
        // Zapisujemy nowego studenta w bazie danych
        entityManager.persist(student);
    }

    /**
     * Usuwa studenta z bazy danych na podstawie jego ID.
     *
     * @param id identyfikator studenta, który ma zostać usunięty
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu StudentDao
    public void usunStudenta(Integer id) {
        // Znajdujemy studenta po ID
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            // Usuwamy studenta, jeśli został znaleziony
            entityManager.remove(student);
        }
    }

    /**
     * Zmienia hasło studenta na nowe, zaszyfrowane hasło.
     *
     * @param studentId identyfikator studenta, którego hasło ma zostać zmienione
     * @param noweHasloHash zaszyfrowane nowe hasło
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu StudentDao
    public void zmienHaslo(Integer studentId, String noweHasloHash) {
        // Tworzymy zapytanie JPQL do zaktualizowania hasła studenta
        Query query = entityManager.createQuery(
                "UPDATE Student s SET s.haslo = :haslo WHERE s.id = :id");
        query.setParameter("haslo", noweHasloHash); // Ustawiamy parametr z nowym hasłem
        query.setParameter("id", studentId); // Ustawiamy parametr studentId
        query.executeUpdate(); // Wykonujemy aktualizację
    }
}