package WWSIS.repository;

import WWSIS.entity.Przedmiot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrzedmiotRepository extends JpaRepository<Przedmiot, Integer> {
}