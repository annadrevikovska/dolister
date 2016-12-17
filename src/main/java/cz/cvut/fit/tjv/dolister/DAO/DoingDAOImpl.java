package cz.cvut.fit.tjv.dolister.DAO;

import cz.cvut.fit.tjv.dolister.model.Doing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class DoingDAOImpl implements DoingDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Doing> findAll() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Doing> criteria = builder.createQuery(Doing.class);

        // Specify criteria root
        criteria.from(Doing.class);

        // Execute query
        List<Doing> doings = session.createQuery(criteria).getResultList();

        // Close the session
        session.close();

        return doings;
    }

    @Override
    public Doing findById(Long id) {
        Session session = sessionFactory.openSession();

        Doing doing = session.get(Doing.class, id);

        session.close();

        return doing;
    }

    @Override
    public void save(Doing doing) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Save the task
        session.saveOrUpdate(doing);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }

    @Override
    public void delete(Doing doing) {

    }
}
