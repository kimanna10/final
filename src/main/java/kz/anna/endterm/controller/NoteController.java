package kz.anna.endterm.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.anna.endterm.entity.Note;
import kz.anna.endterm.entity.Style;
import kz.anna.endterm.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/note")
@Api(value = "NoteControllerClass", description = "This class allows to interact with Note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/all")  //  get all notes from db
    @ApiOperation(value = "Method to get list of notes", response = List.class)
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }


    @GetMapping("/create")
    @ApiOperation(value = "Method to create notes by GET", response = List.class)
    public void createNoteBy(@RequestParam("client") Long client_id, @RequestParam("team") Long team_id,@RequestParam("date") Date date) {
        Note note = new Note();
        note.setClient_id(client_id);
        note.setTeam_id(team_id);
        note.setDate(date);

        noteService.createNote(note);
    }

    @PostMapping
    @ApiOperation(value = "Method to create notes by POST", response = List.class)
    public void createNote(@RequestBody Note note) {
        System.out.println("NoteController.createNote");
        System.out.println("note = " + note);

        noteService.createNote(note);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Method to update notes by Id", response = List.class)
    public void updateNote(@PathVariable Long id,
                            @RequestBody Note note) {

        System.out.println("NoteController.updateNote");
        System.out.println("id = " + id);

        noteService.updateNote(id, note);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Method to delete notes", response = List.class)
    public void deleteNote(@PathVariable Long id) {

        System.out.println("NoteController.deleteNote");
        System.out.println("id = " + id);

        noteService.deleteNote(id);
    }
}
