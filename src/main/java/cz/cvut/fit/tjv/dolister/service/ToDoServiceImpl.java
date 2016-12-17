package cz.cvut.fit.tjv.dolister.service;

import cz.cvut.fit.tjv.dolister.DAO.ToDoDAO;
import cz.cvut.fit.tjv.dolister.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {
    @Autowired
    private ToDoDAO toDoDAO;

    @Override
    public List<ToDo> findAll() {
        return toDoDAO.findAll();
    }

    @Override
    public ToDo findById(Long id) {
        return toDoDAO.findById(id);
    }

    @Override
    public void save(ToDo toDo) {
        toDoDAO.save(toDo);
    }

    @Override
    public void delete(ToDo toDo) {

    }
}
