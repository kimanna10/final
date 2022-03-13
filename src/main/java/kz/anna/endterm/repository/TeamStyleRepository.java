package kz.anna.endterm.repository;

import kz.anna.endterm.entity.TeamStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface TeamStyleRepository extends JpaRepository<TeamStyle, Long> {
}
