package kz.anna.endterm.service.impl;
import kz.anna.endterm.entity.Note;
import kz.anna.endterm.repository.NoteRepository;
import kz.anna.endterm.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public void createNote(Note note) {
        noteRepository.saveAndFlush(note);
    }

    @Override
    public void updateNote(Long id, Note note) {
        Note userDb = noteRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setClient_id(note.getClient_id());
            userDb.setTeam_id(note.getTeam_id());
            userDb.setDate(note.getDate());
            noteRepository.saveAndFlush(userDb);
        }
    }

    @Override
    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id).get();
        noteRepository.delete(note);
    }

}
