package com.lcsmilhan.todo.domain.model

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {

    companion object {
        val noteColors = listOf(
            Color.Red.copy(0.4f),
            Color.Green.copy(0.4f),
            Color.Yellow.copy(0.4f),
            Color.Magenta.copy(0.4f),
            Color.Blue.copy(0.4f)
        )
    }

}

class InvalidNoteException(message: String): Exception(message)
