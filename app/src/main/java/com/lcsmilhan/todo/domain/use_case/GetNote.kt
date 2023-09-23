package com.lcsmilhan.todo.domain.use_case

import com.lcsmilhan.todo.domain.model.Note
import com.lcsmilhan.todo.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }

}