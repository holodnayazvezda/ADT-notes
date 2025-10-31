package com.example.adt_notes.presentation.components.notes_screen_top_up_bar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.adt_notes.domain.usecase.NotesScreenTopAppBarUsecase

class NotesScreenTopAppBarViewModel(
    notesScreenTopAppBarUsecase: NotesScreenTopAppBarUsecase = NotesScreenTopAppBarUsecase()
) : ViewModel() {
    var date by mutableStateOf("")

    init {
        date = notesScreenTopAppBarUsecase.getFormatedSystemDate()
    }
}