package cz.cvut.fit.tjv.dolister.service;

import cz.cvut.fit.tjv.dolister.DAO.DoneDAO;
import cz.cvut.fit.tjv.dolister.model.Done;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoneServiceImpl implements DoneService {
    @Autowired
    private DoneDAO doneDAO;

    @Override
    public List<Done> findAll() {
        return doneDAO.findAll();
    }

    @Override
    public Done findById(Long id) {
        return doneDAO.findById(id);
    }

    @Override
    public void save(Done done) {
        doneDAO.save(done);
    }

    @Override
    public void delete(Done done) {

    }
}
