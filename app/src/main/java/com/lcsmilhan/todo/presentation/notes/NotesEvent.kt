package com.lcsmilhan.todo.presentation.notes

import com.lcsmilhan.todo.domain.model.Note
import com.lcsmilhan.todo.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
