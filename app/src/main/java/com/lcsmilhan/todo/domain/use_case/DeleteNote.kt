package com.lcsmilhan.todo.domain.use_case

import com.lcsmilhan.todo.domain.model.Note
import com.lcsmilhan.todo.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }

}