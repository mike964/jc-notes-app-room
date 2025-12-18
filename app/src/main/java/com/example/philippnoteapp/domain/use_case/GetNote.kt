package com.example.philippnoteapp.domain.use_case

import com.example.philippnoteapp.domain.model.Note
import com.example.philippnoteapp.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}