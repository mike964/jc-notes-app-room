package com.example.philippnoteapp.feature_note.presentation.notes

import com.example.philippnoteapp.domain.model.Note
import com.example.philippnoteapp.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
