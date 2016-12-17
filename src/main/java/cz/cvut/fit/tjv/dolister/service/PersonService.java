package cz.cvut.fit.tjv.dolister.service;

import cz.cvut.fit.tjv.dolister.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findById(Long id);
    void save(Person person);
}
