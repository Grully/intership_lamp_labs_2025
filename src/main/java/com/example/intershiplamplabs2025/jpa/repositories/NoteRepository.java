package com.example.intershiplamplabs2025.jpa.repositories;

import com.example.intershiplamplabs2025.jpa.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}