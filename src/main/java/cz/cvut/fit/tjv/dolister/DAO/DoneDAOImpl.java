package cz.cvut.fit.tjv.dolister.DAO;

import cz.cvut.fit.tjv.dolister.model.Done;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class DoneDAOImpl implements DoneDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Done> findAll() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Done> criteria = builder.createQuery(Done.class);

        // Specify criteria root
        criteria.from(Done.class);

        // Execute query
        List<Done> dones = session.createQuery(criteria).getResultList();

        // Close the session
        session.close();

        return dones;
    }

    @Override
    public Done findById(Long id) {
        Session session = sessionFactory.openSession();

        Done done = session.get(Done.class, id);

        session.close();

        return done;
    }

    @Override
    public void save(Done done) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Save the task
        session.saveOrUpdate(done);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }

    @Override
    public void delete(Done done) {

    }
}
