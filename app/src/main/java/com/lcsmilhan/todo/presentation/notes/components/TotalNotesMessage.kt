package com.lcsmilhan.todo.presentation.notes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lcsmilhan.todo.presentation.notes.NotesViewModel

@Composable
fun TotalNotesMessage(viewModel: NotesViewModel = hiltViewModel()) {
    val notesState = viewModel.state.value

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        if (notesState.notes.isNotEmpty()) {
            Text(
                text = if (notesState.notes.size == 1) {
                    "You have ${notesState.notes.size} note."
                } else "You have ${notesState.notes.size} notes.",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
