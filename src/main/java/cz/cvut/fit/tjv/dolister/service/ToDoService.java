package cz.cvut.fit.tjv.dolister.service;

import cz.cvut.fit.tjv.dolister.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> findAll();
    ToDo findById(Long id);
    void save(ToDo toDo);
    void delete(ToDo toDo);
}
