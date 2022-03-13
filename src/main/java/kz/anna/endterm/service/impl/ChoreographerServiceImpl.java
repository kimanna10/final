package kz.anna.endterm.service.impl;

import kz.anna.endterm.entity.Choreographer;
import kz.anna.endterm.repository.ChoreographerRepository;
import kz.anna.endterm.service.ChoreographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class ChoreographerServiceImpl implements ChoreographerService {

    @Autowired
    private ChoreographerRepository choreographerRepository;

    @Override
    public List<Choreographer> getAllChoreographers() {
        return choreographerRepository.findAll();
    }

    @Override
    public void createChoreographer(Choreographer choreographer) {
        choreographerRepository.saveAndFlush(choreographer);
    }

    @Override
    public void updateChoreographer(Long id, Choreographer choreographer) {
        Choreographer userDb = choreographerRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setName(choreographer.getName());
            choreographerRepository.saveAndFlush(userDb);
        }
    }

    @Override
    public void deleteChoreographer(Long id) {
        Choreographer choreographer = choreographerRepository.findById(id).get();
        choreographerRepository.delete(choreographer);
    }

}
