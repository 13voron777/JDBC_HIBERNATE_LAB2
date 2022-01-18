package LAB6;

import LAB6.entity.GrupEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GrupHelper {
    private SessionFactory sessionFactory;

    public GrupHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    // 3
    public List<GrupEntity> getGroupList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<GrupEntity> cq = cb.createQuery(GrupEntity.class);
        Root<GrupEntity> root = cq.from(GrupEntity.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<GrupEntity> groups = query.getResultList();
        session.close();
        return groups;
    }
}
