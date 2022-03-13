package kz.anna.endterm.repository;

import kz.anna.endterm.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
}
