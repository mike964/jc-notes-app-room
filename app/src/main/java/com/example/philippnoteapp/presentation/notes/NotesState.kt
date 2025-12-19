package com.example.philippnoteapp.presentation.notes

import com.example.philippnoteapp.domain.model.Note
import com.example.philippnoteapp.domain.util.NoteOrder
import com.example.philippnoteapp.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
