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
@Transactional
public class ZapisDaoImpl implements ZapisDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Zapis pobierzZapis(Integer id) {
        return entityManager.find(Zapis.class, id);
    }

    @Override
    public List<Zapis> pobierzZapisyStudenta(Integer studentId) {
        Query query = entityManager.createQuery(
                "SELECT z FROM Zapis z WHERE z.student.id = :studentId");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public List<Zapis> pobierzZapisyNaGrupe(Integer grupaId) {
        Query query = entityManager.createQuery(
                "SELECT z FROM Zapis z WHERE z.grupa.grupaId = :grupaId");
        query.setParameter("grupaId", grupaId);
        return query.getResultList();
    }

    @Override
    public List<Zapis> pobierzAktywneZapisyStudenta(Integer studentId) {
        Query query = entityManager.createQuery(
                "SELECT z FROM Zapis z WHERE z.student.id = :studentId AND z.status = 'zapisany'");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public void zapiszZapis(Zapis zapis) {
        entityManager.persist(zapis);
    }

    @Override
    public void anulujZapis(Integer zapisId) {
        Query query = entityManager.createQuery(
                "UPDATE Zapis z SET z.status = 'wypisany' WHERE z.zapisId = :id");
        query.setParameter("id", zapisId);
        query.executeUpdate();
    }

    @Override
    public void usunZapis(Integer zapisId) {
        Zapis z = entityManager.find(Zapis.class, zapisId);
        if (z != null) {
            entityManager.remove(z);
        }
    }
}