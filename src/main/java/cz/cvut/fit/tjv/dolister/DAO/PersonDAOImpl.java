package cz.cvut.fit.tjv.dolister.DAO;

import cz.cvut.fit.tjv.dolister.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Person> findAll() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Person> criteria = builder.createQuery(Person.class);

        // Specify criteria root
        criteria.from(Person.class);

        // Execute query
        List<Person> people = session.createQuery(criteria).getResultList();

        // Close the session
        session.close();

        return people;
    }

    @Override
    public Person findById(Long id) {
        Session session = sessionFactory.openSession();

        Person person = session.get(Person.class, id);

        session.close();

        return person;
    }

    @Override
    public void save(Person person) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Save the task
        session.saveOrUpdate(person);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }
}
