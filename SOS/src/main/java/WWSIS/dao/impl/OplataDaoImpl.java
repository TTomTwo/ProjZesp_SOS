package WWSIS.dao.impl;

import WWSIS.dao.OplataDao;
import WWSIS.entity.Oplata;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class OplataDaoImpl implements OplataDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Oplata pobierzOplate(Integer id) {
        return entityManager.find(Oplata.class, id);
    }

    @Override
    public List<Oplata> pobierzWszystkieOplatyStudenta(Integer studentId) {
        Query query = entityManager.createQuery(
                "SELECT o FROM Oplata o WHERE o.student.id = :studentId");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public List<Oplata> pobierzZalegleOplatyStudenta(Integer studentId) {
        Query query = entityManager.createQuery(
                "SELECT o FROM Oplata o WHERE o.student.id = :studentId AND o.status = 'nieoplacone'");
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public void zapiszOplate(Oplata oplata) {
        entityManager.persist(oplata);
    }
}