package WWSIS.dao.impl;

import WWSIS.dao.ZapisDao;
import WWSIS.entity.Zapis;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional // Adnotacja zapewniająca zarządzanie transakcjami – operacje na bazie będą wykonywane w ramach jednej transakcji
public class ZapisDaoImpl implements ZapisDao {

    // Wstrzykiwanie EntityManager, który będzie używany do operacji na bazie danych
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Pobiera zapis na podstawie jego ID.
     * @param id identyfikator zapisu
     * @return Zapis obiekt zapisu lub null, jeśli zapis o danym ID nie istnieje
     */
    @Override
    public Zapis pobierzZapis(Integer id) {
        // Znajdujemy zapis po ID w bazie danych
        return entityManager.find(Zapis.class, id);
    }

    /**
     * Pobiera wszystkie zapisy danego studenta.
     * @param studentId identyfikator studenta
     * @return Lista zapisów studenta
     */
    @Override
    public List<Zapis> pobierzZapisyStudenta(Integer studentId) {
        // Tworzymy zapytanie JPQL do pobrania wszystkich zapisów dla danego studenta
        Query query = entityManager.createQuery(
                "SELECT z FROM Zapis z WHERE z.student.id = :studentId");
        query.setParameter("studentId", studentId); // Ustawiamy parametr studentId
        return query.getResultList(); // Zwracamy listę wyników
    }

    /**
     * Pobiera wszystkie zapisy przypisane do danej grupy.
     * @param grupaId identyfikator grupy
     * @return Lista zapisów na grupę
     */
    @Override
    public List<Zapis> pobierzZapisyNaGrupe(Integer grupaId) {
        // Tworzymy zapytanie JPQL do pobrania zapisów na grupę
        Query query = entityManager.createQuery(
                "SELECT z FROM Zapis z WHERE z.grupa.grupaId = :grupaId");
        query.setParameter("grupaId", grupaId); // Ustawiamy parametr grupaId
        return query.getResultList(); // Zwracamy listę zapisów na grupę
    }

    /**
     * Pobiera aktywne zapisy studenta, czyli zapisy o statusie "zapisany".
     * @param studentId identyfikator studenta
     * @return Lista aktywnych zapisów studenta
     */
    @Override
    public List<Zapis> pobierzAktywneZapisyStudenta(Integer studentId) {
        // Tworzymy zapytanie JPQL do pobrania aktywnych zapisów studenta
        Query query = entityManager.createQuery(
                "SELECT z FROM Zapis z WHERE z.student.id = :studentId AND z.status = 'zapisany'");
        query.setParameter("studentId", studentId); // Ustawiamy parametr studentId
        return query.getResultList(); // Zwracamy listę aktywnych zapisów
    }

    /**
     * Zapisuje nowy zapis do bazy danych.
     * @param zapis obiekt zapisu do zapisania
     */
    @Override
    public void zapiszZapis(Zapis zapis) {
        // Zapisujemy nowy obiekt zapis w bazie danych
        entityManager.persist(zapis);
    }

    /**
     * Anuluje zapis, zmieniając jego status na "wypisany".
     * @param zapisId identyfikator zapisu, który ma zostać anulowany
     */
    @Override
    public void anulujZapis(Integer zapisId) {
        // Tworzymy zapytanie JPQL do zmiany statusu zapisu na "wypisany"
        Query query = entityManager.createQuery(
                "UPDATE Zapis z SET z.status = 'wypisany' WHERE z.zapisId = :id");
        query.setParameter("id", zapisId); // Ustawiamy parametr zapisId
        query.executeUpdate(); // Wykonujemy aktualizację
    }

    /**
     * Usuwa zapis na grupę z bazy danych.
     * @param zapisId identyfikator zapisu, który ma zostać usunięty
     */
    @Override
    public void usunZapis(Integer zapisId) {
        // Znajdujemy zapis po ID
        Zapis z = entityManager.find(Zapis.class, zapisId);
        if (z != null) {
            // Usuwamy zapis, jeśli został znaleziony
            entityManager.remove(z);
        }
    }
}