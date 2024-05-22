package mr.iscae.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import mr.iscae.entities.Student;

import java.util.List;

public class StudentRepository {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myUnit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Student> getAll() {
        String sql = "select s from Student s";
        TypedQuery<Student> qr = entityManager.createQuery(sql, Student.class);
        return qr.getResultList();
    }

    public Student add(Student Student) {
        entityManager.getTransaction().begin();
        entityManager.persist(Student);
        entityManager.getTransaction().commit();
        return Student;
    }
}
