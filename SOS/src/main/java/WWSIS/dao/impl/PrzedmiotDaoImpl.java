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

@Repository
@Transactional
public class PrzedmiotDaoImpl implements PrzedmiotDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Przedmiot pobierzPrzedmiot(Integer id) {
        return entityManager.find(Przedmiot.class, id);
    }

    @Override
    public List<Przedmiot> pobierzWszystkiePrzedmioty() {
        Query query = entityManager.createQuery("SELECT p FROM Przedmiot p");
        return query.getResultList();
    }

    @Override
    public String pobierzOpisPrzedmiotu(Integer przedmiotId) {
        Przedmiot p = entityManager.find(Przedmiot.class, przedmiotId);
        return p != null ? p.getOpis() : null;
    }

    @Override
    public List<Grupa> pobierzGrupyPrzedmiotu(Integer przedmiotId) {
        Query query = entityManager.createQuery(
                "SELECT g FROM Grupa g WHERE g.przedmiot.przedmiotId = :id");
        query.setParameter("id", przedmiotId);
        return query.getResultList();
    }

    @Override
    public void zapiszPrzedmiot(Przedmiot przedmiot) {
        entityManager.persist(przedmiot);
    }

    @Override
    public void usunPrzedmiot(Integer id) {
        Przedmiot p = entityManager.find(Przedmiot.class, id);
        if (p != null) {
            entityManager.remove(p);
        }
    }
}