package com.lcsmilhan.todo.presentation.notes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lcsmilhan.todo.presentation.notes.NotesViewModel

@Composable
fun TotalNotesMessage(viewModel: NotesViewModel = hiltViewModel()) {
    val notesState = viewModel.state.value

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "You have ${notesState.notes.size} notes!",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
