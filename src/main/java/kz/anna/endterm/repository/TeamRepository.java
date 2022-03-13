package kz.anna.endterm.repository;

import kz.anna.endterm.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
