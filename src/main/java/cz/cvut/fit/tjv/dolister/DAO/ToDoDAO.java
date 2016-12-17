package cz.cvut.fit.tjv.dolister.DAO;

import cz.cvut.fit.tjv.dolister.model.ToDo;

import java.util.List;

public interface ToDoDAO {
    List<ToDo> findAll();
    ToDo findById(Long id);
    void save(ToDo toDo);
    void delete(ToDo toDo);
}
