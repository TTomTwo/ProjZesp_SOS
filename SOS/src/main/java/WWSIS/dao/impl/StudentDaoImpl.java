package WWSIS.dao.impl;

import WWSIS.dao.StudentDao;
import WWSIS.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Student pobierzStudenta(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student pobierzStudentaPoEmailu(String email) {
        Query query = entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.email = :email");
        query.setParameter("email", email);
        List<Student> wyniki = query.getResultList();
        return wyniki.isEmpty() ? null : wyniki.get(0);
    }

    @Override
    public Student pobierzStudentaPoIndeksie(String nrIndeksu) {
        Query query = entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.nrIndeksu = :nrIndeksu");
        query.setParameter("nrIndeksu", nrIndeksu);
        List<Student> wyniki = query.getResultList();
        return wyniki.isEmpty() ? null : wyniki.get(0);
    }

    @Override
    public List<Student> pobierzWszystkichStudentow() {
        Query query = entityManager.createQuery("SELECT s FROM Student s");
        return query.getResultList();
    }

    @Override
    public void zapiszStudenta(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void usunStudenta(Integer id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public void zmienHaslo(Integer studentId, String noweHasloHash) {
        Query query = entityManager.createQuery(
                "UPDATE Student s SET s.haslo = :haslo WHERE s.id = :id");
        query.setParameter("haslo", noweHasloHash);
        query.setParameter("id", studentId);
        query.executeUpdate();
    }
}