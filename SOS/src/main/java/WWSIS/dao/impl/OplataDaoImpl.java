package WWSIS.dao.impl;

import WWSIS.dao.OplataDao;
import WWSIS.entity.Oplata;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository // Adnotacja wskazująca, że jest to klasa repozytorium
@Transactional // Adnotacja zapewniająca zarządzanie transakcjami – operacje na bazie będą wykonywane w ramach jednej transakcji
public class OplataDaoImpl implements OplataDao {

    // Wstrzykiwanie EntityManager, który będzie używany do operacji na bazie danych
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Pobiera opłatę na podstawie jej identyfikatora.
     *
     * @param id identyfikator opłaty
     * @return Oplata obiekt opłaty lub null, jeśli opłata o danym ID nie istnieje
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu OplataDao
    public Oplata pobierzOplate(Integer id) {
        // Znajdujemy opłatę po ID w bazie danych
        return entityManager.find(Oplata.class, id);
    }

    /**
     * Pobiera wszystkie opłaty danego studenta na podstawie jego ID.
     *
     * @param studentId identyfikator studenta
     * @return Lista opłat studenta
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu OplataDao
    public List<Oplata> pobierzWszystkieOplatyStudenta(Integer studentId) {
        // Tworzymy zapytanie JPQL do pobrania wszystkich opłat dla danego studenta
        Query query = entityManager.createQuery(
                "SELECT o FROM Oplata o WHERE o.student.id = :studentId");
        query.setParameter("studentId", studentId); // Ustawiamy parametr studentId
        return query.getResultList(); // Zwracamy listę wyników
    }

    /**
     * Pobiera wszystkie zaległe opłaty studenta (status = "nieoplacone").
     *
     * @param studentId identyfikator studenta
     * @return Lista zaległych opłat studenta
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu OplataDao
    public List<Oplata> pobierzZalegleOplatyStudenta(Integer studentId) {
        // Tworzymy zapytanie JPQL do pobrania zaległych opłat studenta
        Query query = entityManager.createQuery(
                "SELECT o FROM Oplata o WHERE o.student.id = :studentId AND o.status = 'nieoplacone'");
        query.setParameter("studentId", studentId); // Ustawiamy parametr studentId
        return query.getResultList(); // Zwracamy listę zaległych opłat
    }

    /**
     * Zapisuje nową opłatę do bazy danych.
     *
     * @param oplata obiekt opłaty do zapisania
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu OplataDao
    public void zapiszOplate(Oplata oplata) {
        // Zapisujemy nową opłatę w bazie danych
        entityManager.persist(oplata);
    }
}