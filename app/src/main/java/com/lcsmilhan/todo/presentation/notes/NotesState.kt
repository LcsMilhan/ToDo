package com.lcsmilhan.todo.presentation.notes

import com.lcsmilhan.todo.domain.model.Note
import com.lcsmilhan.todo.domain.util.NoteOrder
import com.lcsmilhan.todo.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
