package cz.cvut.fit.tjv.dolister.service;

import cz.cvut.fit.tjv.dolister.DAO.PersonDAO;
import cz.cvut.fit.tjv.dolister.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDAO personDAO;

    @Override
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personDAO.findById(id);
    }

    @Override
    public void save(Person person) {
        personDAO.save(person);
    }
}
