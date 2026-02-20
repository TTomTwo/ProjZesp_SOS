package WWSIS.dao.impl;

import WWSIS.dao.WypozyczenieDao;
import WWSIS.entity.WypozyczenieKsiazki;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class WypozyczenieDaoImpl implements WypozyczenieDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public WypozyczenieKsiazki pobierzWypozyczenie(Integer id) {
        return entityManager.find(WypozyczenieKsiazki.class, id);
    }

    @Override
    public List<WypozyczenieKsiazki> pobierzWypozyczeniaStudenta(Integer studentId) {
        Query query = entityManager.createQuery(
                "SELECT w FROM WypozyczenieKsiazki w WHERE w.student.id = :studentId");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public List<WypozyczenieKsiazki> pobierzAktywneWypozyczenia(Integer studentId) {
        Query query = entityManager.createQuery(
                "SELECT w FROM WypozyczenieKsiazki w WHERE w.student.id = :studentId AND w.status = 'wypozyczona'");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public List<WypozyczenieKsiazki> pobierzPrzeterminowane(Integer studentId) {
        Query query = entityManager.createQuery(
                "SELECT w FROM WypozyczenieKsiazki w WHERE w.student.id = :studentId AND w.status = 'przeterminowana'");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public void zapiszWypozyczenie(WypozyczenieKsiazki wypozyczenie) {
        entityManager.persist(wypozyczenie);
    }
}