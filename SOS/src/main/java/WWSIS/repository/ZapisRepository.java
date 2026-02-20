package WWSIS.repository;

import WWSIS.entity.Zapis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZapisRepository extends JpaRepository<Zapis, Integer> {
}