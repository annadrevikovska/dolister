package cz.cvut.fit.tjv.dolister.DAO;

import cz.cvut.fit.tjv.dolister.model.Done;

import java.util.List;

public interface DoneDAO {
    List<Done> findAll();
    Done findById(Long id);
    void save(Done done);
    void delete(Done done);
}
