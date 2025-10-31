package com.example.adt_notes.ui.screens.main.botttom_navigation.notes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.adt_notes.domain.usecase.NotesUsecase

class NotesScreenViewModel(
    notesUsecase: NotesUsecase = NotesUsecase()
) : ViewModel() {
    var date by mutableStateOf("")

    init {
        date = notesUsecase.getFormatedSystemDate()
    }
}