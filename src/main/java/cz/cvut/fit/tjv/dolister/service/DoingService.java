package cz.cvut.fit.tjv.dolister.service;

import cz.cvut.fit.tjv.dolister.model.Doing;

import java.util.List;

public interface DoingService {
    List<Doing> findAll();
    Doing findById(Long id);
    void save(Doing doing);
    void delete(Doing doing);
}
