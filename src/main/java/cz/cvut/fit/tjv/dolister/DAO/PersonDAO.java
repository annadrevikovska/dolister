package cz.cvut.fit.tjv.dolister.DAO;

import cz.cvut.fit.tjv.dolister.model.Person;

import java.util.List;

public interface PersonDAO {
    List<Person> findAll();
    Person findById(Long id);
    void save(Person person);
}
