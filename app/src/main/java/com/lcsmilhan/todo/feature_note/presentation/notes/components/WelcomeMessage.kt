package com.lcsmilhan.todo.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lcsmilhan.todo.feature_note.presentation.notes.NotesViewModel

@Composable
fun WelcomeMessage(viewModel: NotesViewModel = hiltViewModel()) {
    val notesState = viewModel.state.value

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "${notesState.notes.size} Notes!",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
