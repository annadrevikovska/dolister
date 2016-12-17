package cz.cvut.fit.tjv.dolister.service;

import cz.cvut.fit.tjv.dolister.model.Done;

import java.util.List;

public interface DoneService {
    List<Done> findAll();
    Done findById(Long id);
    void save(Done done);
    void delete(Done done);
}
