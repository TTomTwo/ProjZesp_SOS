package WWSIS.dao.impl;

import WWSIS.dao.PrzedmiotDao;
import WWSIS.entity.Grupa;
import WWSIS.entity.Przedmiot;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository // Adnotacja wskazująca, że jest to klasa repozytorium
@Transactional // Adnotacja zapewniająca zarządzanie transakcjami – operacje na bazie będą wykonywane w ramach jednej transakcji
public class PrzedmiotDaoImpl implements PrzedmiotDao {

    // Wstrzykiwanie EntityManager, który będzie używany do operacji na bazie danych
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Pobiera przedmiot na podstawie jego identyfikatora.
     *
     * @param id identyfikator przedmiotu
     * @return Przedmiot obiekt przedmiotu lub null, jeśli przedmiot o danym ID nie istnieje
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu PrzedmiotDao
    public Przedmiot pobierzPrzedmiot(Integer id) {
        // Znajdujemy przedmiot po ID w bazie danych
        return entityManager.find(Przedmiot.class, id);
    }

    /**
     * Pobiera listę wszystkich przedmiotów.
     *
     * @return Lista wszystkich przedmiotów
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu PrzedmiotDao
    public List<Przedmiot> pobierzWszystkiePrzedmioty() {
        // Tworzymy zapytanie JPQL do pobrania wszystkich przedmiotów
        Query query = entityManager.createQuery("SELECT p FROM Przedmiot p");
        return query.getResultList(); // Zwracamy listę wyników
    }

    /**
     * Pobiera opis przedmiotu na podstawie jego ID.
     *
     * @param przedmiotId identyfikator przedmiotu
     * @return Opis przedmiotu lub null, jeśli przedmiot o podanym ID nie istnieje
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu PrzedmiotDao
    public String pobierzOpisPrzedmiotu(Integer przedmiotId) {
        // Znajdujemy przedmiot po ID
        Przedmiot p = entityManager.find(Przedmiot.class, przedmiotId);
        // Zwracamy opis przedmiotu, jeśli przedmiot istnieje, w przeciwnym razie null
        return p != null ? p.getOpis() : null;
    }

    /**
     * Pobiera grupy przypisane do przedmiotu na podstawie jego ID.
     *
     * @param przedmiotId identyfikator przedmiotu
     * @return Lista grup przypisanych do przedmiotu
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu PrzedmiotDao
    public List<Grupa> pobierzGrupyPrzedmiotu(Integer przedmiotId) {
        // Tworzymy zapytanie JPQL do pobrania grup przypisanych do przedmiotu
        Query query = entityManager.createQuery(
                "SELECT g FROM Grupa g WHERE g.przedmiot.przedmiotId = :id");
        query.setParameter("id", przedmiotId); // Ustawiamy parametr przedmiotId
        return query.getResultList(); // Zwracamy listę grup
    }

    /**
     * Zapisuje nowy przedmiot do bazy danych.
     *
     * @param przedmiot obiekt przedmiotu do zapisania
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu PrzedmiotDao
    public void zapiszPrzedmiot(Przedmiot przedmiot) {
        // Zapisujemy nowy obiekt przedmiotu w bazie danych
        entityManager.persist(przedmiot);
    }

    /**
     * Usuwa przedmiot z bazy danych na podstawie jego ID.
     *
     * @param id identyfikator przedmiotu, który ma zostać usunięty
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu PrzedmiotDao
    public void usunPrzedmiot(Integer id) {
        // Znajdujemy przedmiot po ID
        Przedmiot p = entityManager.find(Przedmiot.class, id);
        if (p != null) {
            // Usuwamy przedmiot, jeśli został znaleziony
            entityManager.remove(p);
        }
    }
}