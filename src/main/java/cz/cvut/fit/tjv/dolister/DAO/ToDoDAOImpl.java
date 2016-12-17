package cz.cvut.fit.tjv.dolister.DAO;

import cz.cvut.fit.tjv.dolister.model.ToDo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class ToDoDAOImpl implements ToDoDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ToDo> findAll() {
        // Open a session
        Session session = sessionFactory.openSession();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<ToDo> criteria = builder.createQuery(ToDo.class);

        // Specify criteria root
        criteria.from(ToDo.class);

        // Execute query
        List<ToDo> toDos = session.createQuery(criteria).getResultList();

        // Close the session
        session.close();

        return toDos;
    }

    @Override
    public ToDo findById(Long id) {
        Session session = sessionFactory.openSession();

        ToDo toDo = session.get(ToDo.class, id);

        session.close();

        return toDo;
    }

    @Override
    public void save(ToDo toDo) {
        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Save the task
        session.saveOrUpdate(toDo);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();
    }

    @Override
    public void delete(ToDo toDo) {

    }
}
