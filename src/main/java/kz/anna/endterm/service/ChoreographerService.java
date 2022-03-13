package kz.anna.endterm.service;

import kz.anna.endterm.entity.Choreographer;

import java.util.List;

public interface ChoreographerService {

    List<Choreographer> getAllChoreographers();
    void createChoreographer(Choreographer choreographer);
    void updateChoreographer(Long id, Choreographer choreographer);
    void deleteChoreographer(Long id);
}
