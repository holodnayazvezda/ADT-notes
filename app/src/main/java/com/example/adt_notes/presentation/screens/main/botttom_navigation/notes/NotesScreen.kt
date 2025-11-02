package com.example.adt_notes.presentation.screens.main.botttom_navigation.notes

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NotesScreen(
    notesScreenViewModel: NotesScreenViewModel
) {
    val colorScheme = MaterialTheme.colorScheme



}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun NotesScreenPreview() {
    NotesScreen(
        notesScreenViewModel = NotesScreenViewModel()
    )
}