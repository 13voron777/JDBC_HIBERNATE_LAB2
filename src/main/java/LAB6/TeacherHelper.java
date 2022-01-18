package LAB6;

import LAB6.entity.TeacherEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class TeacherHelper {
    private SessionFactory sessionFactory;

    public TeacherHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    // 1
    public List<TeacherEntity> getSelectionWhere() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<TeacherEntity> cq = cb.createQuery(TeacherEntity.class);

        Root<TeacherEntity> root = cq.from(TeacherEntity.class);
        Selection[] selections = {root.get("name"), root.get("lastname")};
        cq.select(cb.construct(TeacherEntity.class, selections))
        .where(cb.like(root.<String>get("lastname"), "%eni%"));

        Query query = session.createQuery(cq);
        List<TeacherEntity> teacherList = query.getResultList();
        session.close();
        return teacherList;
    }

    public TeacherEntity addTeacher(TeacherEntity teacher) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
        return teacher;
    }

    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        TeacherEntity teacher = session.get(TeacherEntity.class, id);
        session.delete(teacher);
        session.getTransaction().commit();
        session.close();
    }

    // 2
    public void deleteCriteria() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<TeacherEntity> cd = cb.createCriteriaDelete(TeacherEntity.class);
        Root<TeacherEntity> root = cd.from(TeacherEntity.class);
        cd.where(cb.like(root.<String>get("name"), "%st%"));
        Query query = session.createQuery(cd);
        int deletedValues = query.executeUpdate();
        System.out.println("Deleted values: " + deletedValues);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteCriteriaLogic() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<TeacherEntity> cd = cb.createCriteriaDelete(TeacherEntity.class);

        Root<TeacherEntity> root = cd.from(TeacherEntity.class);
        cd.where(cb.or(
                cb.like(root.<String>get("name"), "%st%"),
                cb.equal(root.get("lastname"), "Fridrich")
        ));

        Query query = session.createQuery(cd);
        int deletedValues = query.executeUpdate();
        System.out.println("Deleted values: " + deletedValues);
        session.getTransaction().commit();
        session.close();
    }
}
