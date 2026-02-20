package WWSIS.dao.impl;

import WWSIS.dao.WypozyczenieDao;
import WWSIS.entity.WypozyczenieKsiazki;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository // Adnotacja wskazująca, że jest to klasa repozytorium
@Transactional // Adnotacja zapewniająca zarządzanie transakcjami
public class WypozyczenieDaoImpl implements WypozyczenieDao {

    // Wstrzykiwanie EntityManager, który jest używany do operacji na bazie danych
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Pobiera wypożyczenie na podstawie jego identyfikatora.
     *
     * @param id identyfikator wypożyczenia
     * @return WypozyczenieKsiazki obiekt wypożyczenia lub null, jeśli wypożyczenie o danym ID nie istnieje
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu WypozyczenieDao
    public WypozyczenieKsiazki pobierzWypozyczenie(Integer id) {
        // Znajdujemy wypożyczenie po ID w bazie danych
        return entityManager.find(WypozyczenieKsiazki.class, id);
    }

    /**
     * Pobiera wszystkie wypożyczenia danego studenta na podstawie jego ID.
     *
     * @param studentId identyfikator studenta
     * @return Lista wypożyczeń studenta
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu WypozyczenieDao
    public List<WypozyczenieKsiazki> pobierzWypozyczeniaStudenta(Integer studentId) {
        // Tworzymy zapytanie JPQL do pobrania wszystkich wypożyczeń dla danego studenta
        Query query = entityManager.createQuery(
                "SELECT w FROM WypozyczenieKsiazki w WHERE w.student.id = :studentId");
        query.setParameter("studentId", studentId); // Ustawiamy parametr studentId
        return query.getResultList(); // Zwracamy listę wyników
    }

    /**
     * Pobiera aktywne wypożyczenia studenta (status = "wypozyczona").
     *
     * @param studentId identyfikator studenta
     * @return Lista aktywnych wypożyczeń studenta
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu WypozyczenieDao
    public List<WypozyczenieKsiazki> pobierzAktywneWypozyczenia(Integer studentId) {
        // Tworzymy zapytanie JPQL do pobrania aktywnych wypożyczeń studenta
        Query query = entityManager.createQuery(
                "SELECT w FROM WypozyczenieKsiazki w WHERE w.student.id = :studentId AND w.status = 'wypozyczona'");
        query.setParameter("studentId", studentId); // Ustawiamy parametr studentId
        return query.getResultList(); // Zwracamy listę aktywnych wypożyczeń
    }

    /**
     * Pobiera wypożyczenia, które są przeterminowane (status = "przeterminowana").
     *
     * @param studentId identyfikator studenta
     * @return Lista przeterminowanych wypożyczeń studenta
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu WypozyczenieDao
    public List<WypozyczenieKsiazki> pobierzPrzeterminowane(Integer studentId) {
        // Tworzymy zapytanie JPQL do pobrania przeterminowanych wypożyczeń studenta
        Query query = entityManager.createQuery(
                "SELECT w FROM WypozyczenieKsiazki w WHERE w.student.id = :studentId AND w.status = 'przeterminowana'");
        query.setParameter("studentId", studentId); // Ustawiamy parametr studentId
        return query.getResultList(); // Zwracamy listę przeterminowanych wypożyczeń
    }

    /**
     * Zapisuje nowe wypożyczenie do bazy danych.
     *
     * @param wypozyczenie obiekt wypożyczenia do zapisania
     */
    @Override // Adnotacja @Override wskazuje, że ta metoda nadpisuje metodę z interfejsu WypozyczenieDao
    public void zapiszWypozyczenie(WypozyczenieKsiazki wypozyczenie) {
        // Zapisujemy nowy obiekt wypożyczenia w bazie danych
        entityManager.persist(wypozyczenie);
    }
}