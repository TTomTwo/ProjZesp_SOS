package WWSIS.repository;

import WWSIS.entity.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupaRepository extends JpaRepository<Grupa, Integer> {

    // JpaRepository zapewnia wszystkie podstawowe operacje CRUD (Create, Read, Update, Delete) dla encji Grupa.
    // Dzięki Spring Data JPA nie musimy implementować metod do takich operacji, ponieważ JpaRepository to robi automatycznie.
    // Dostajemy metody takie jak:
    // - save(S entity)  - zapisywanie lub aktualizowanie grupy
    // - findById(ID id) - znajdowanie grupy po jej identyfikatorze
    // - findAll()       - pobieranie wszystkich grup
    // - deleteById(ID id) - usuwanie grupy po jej ID

}