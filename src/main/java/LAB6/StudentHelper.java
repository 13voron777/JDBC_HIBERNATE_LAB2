package LAB6;

import LAB6.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentHelper {
    private SessionFactory sessionFactory;

    public StudentHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    // 3
    public List<StudentEntity> getStudentsList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> cq = cb.createQuery(StudentEntity.class);
        Root<StudentEntity> root = cq.from(StudentEntity.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<StudentEntity> students = query.getResultList();
        session.close();
        return students;
    }
}
