package WWSIS.repository;

import WWSIS.entity.Przedmiot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrzedmiotRepository extends JpaRepository<Przedmiot, Integer> {

    // JpaRepository zapewnia wszystkie podstawowe operacje CRUD (Create, Read, Update, Delete) dla encji Przedmiot
    // Dzięki Spring Data JPA nie musimy implementować metod do takich operacji, ponieważ JpaRepository to robi automatycznie.
    // Dostajemy metody takie jak:
    // - save(S entity)  - zapisywanie lub aktualizowanie przedmiotu
    // - findById(ID id) - znajdowanie przedmiotu po jego identyfikatorze
    // - findAll()       - pobieranie wszystkich przedmiotów
    // - deleteById(ID id) - usuwanie przedmiotu po jego ID

}