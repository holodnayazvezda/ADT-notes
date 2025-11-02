package com.example.adt_notes.presentation.screens.main.botttom_navigation.notes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.adt_notes.data.navigation.NotesRoutes
import com.example.adt_notes.data.states.NotesState

class NotesScreenViewModel : ViewModel() {
    private var _state by mutableStateOf(NotesState())
    val state
        get() = _state

    fun changeState(
        notesRoute: NotesRoutes = state.notesRoute
    ) {
        _state = _state.copy(
            notesRoute = notesRoute
        )
    }
}