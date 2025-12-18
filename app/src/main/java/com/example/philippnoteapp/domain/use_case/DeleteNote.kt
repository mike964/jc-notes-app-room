package com.example.philippnoteapp.domain.use_case

import com.example.philippnoteapp.domain.model.Note
import com.example.philippnoteapp.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}