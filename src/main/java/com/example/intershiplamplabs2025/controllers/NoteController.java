package com.example.intershiplamplabs2025.controllers;


import com.example.intershiplamplabs2025.dtos.NoteDTO;
import com.example.intershiplamplabs2025.jpa.entities.Note;
import com.example.intershiplamplabs2025.jpa.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @PostMapping("/note")
    public ResponseEntity<Note> createNote(@RequestBody NoteDTO noteDTO) {
        Note note = new Note(noteDTO.getTitle(), noteDTO.getContent());
        Note savedNote = noteRepository.save(note);
        return ResponseEntity.ok(savedNote);
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return ResponseEntity.ok(notes);
    }
}
