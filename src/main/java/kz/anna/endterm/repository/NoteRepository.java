package kz.anna.endterm.repository;

import kz.anna.endterm.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
