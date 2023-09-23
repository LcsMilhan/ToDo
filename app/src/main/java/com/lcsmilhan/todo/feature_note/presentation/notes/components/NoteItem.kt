package com.lcsmilhan.todo.feature_note.presentation.notes.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.lcsmilhan.todo.feature_note.domain.model.Note

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    note: Note,
    cornerRadius: Dp = 10.dp,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
) {
    
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${note.timestamp}",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .border(
                        border = BorderStroke(3.dp, MaterialTheme.colorScheme.primary),
                        shape = CircleShape
                    )
            )

            Divider(Modifier.width(6.dp), color = MaterialTheme.colorScheme.primary)

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = modifier) {
                    Canvas(modifier = Modifier.matchParentSize()) {
                        val clipPath = Path().apply {
                            lineTo(size.width - cutCornerSize.toPx(), 0f)
                            lineTo(size.width, cutCornerSize.toPx())
                            lineTo(size.width, size.height)
                            lineTo(0f, size.height)
                            close()
                        }
                        clipPath(clipPath) {
                            drawRoundRect(
                                color = Color(note.color),
                                size = size,
                                cornerRadius = CornerRadius(cornerRadius.toPx())
                            )
                            drawRoundRect(
                                color = Color(
                                    ColorUtils.blendARGB(note.color, 0x000000, 0.2f)
                                ),
                                topLeft = Offset(size.width - cutCornerSize.toPx(), -100f),
                                size = Size(cutCornerSize.toPx() + 100f, cutCornerSize.toPx() + 100f),
                                cornerRadius = CornerRadius(cornerRadius.toPx())
                            )
                        }
                    }
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(12.dp)
                            .padding(end = 32.dp)
                    ) {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = note.content,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface,
                            maxLines = 5,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    IconButton(
                        onClick = onDeleteClick,
                        modifier = Modifier.align(Alignment.BottomEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete note",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                Divider(
                    modifier = Modifier
                        .width(6.dp)
                        .weight(0.1f), color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}