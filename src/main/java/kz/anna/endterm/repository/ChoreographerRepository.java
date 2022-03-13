package kz.anna.endterm.repository;

import kz.anna.endterm.entity.Choreographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface ChoreographerRepository extends JpaRepository<Choreographer, Long> {
}
