package kz.anna.endterm.service;


import kz.anna.endterm.entity.Note;

import java.util.List;

public interface NoteService {

    List<Note> getAllNotes();
    void createNote(Note note);
    void updateNote(Long id, Note note);
    void deleteNote(Long id);
}
