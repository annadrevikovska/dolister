package cz.cvut.fit.tjv.dolister.service;

import cz.cvut.fit.tjv.dolister.DAO.DoingDAO;
import cz.cvut.fit.tjv.dolister.model.Doing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoingServiceImpl implements DoingService {
    @Autowired
    private DoingDAO doingDAO;

    @Override
    public List<Doing> findAll() {
        return doingDAO.findAll();
    }

    @Override
    public Doing findById(Long id) {
        return doingDAO.findById(id);
    }

    @Override
    public void save(Doing doing) {
        doingDAO.save(doing);
    }

    @Override
    public void delete(Doing doing) {

    }
}
