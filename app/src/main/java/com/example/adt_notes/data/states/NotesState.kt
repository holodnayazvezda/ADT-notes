package com.example.adt_notes.data.states

import com.example.adt_notes.data.navigation.NotesRoutes

data class NotesState(
    val notesRoute: NotesRoutes = NotesRoutes.ALL
)