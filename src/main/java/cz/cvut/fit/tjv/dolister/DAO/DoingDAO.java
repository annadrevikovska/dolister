package cz.cvut.fit.tjv.dolister.DAO;

import cz.cvut.fit.tjv.dolister.model.Doing;

import java.util.List;

public interface DoingDAO {
    List<Doing> findAll();
    Doing findById(Long id);
    void save(Doing doing);
    void delete(Doing doing);
}
