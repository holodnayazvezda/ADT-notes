package com.example.adt_notes.presentation.screens.main.botttom_navigation.notes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.adt_notes.presentation.components.DrawerLayout
import com.example.adt_notes.presentation.components.notes_screen_top_up_bar.NotesScreenTopAppBar

@Composable
fun NotesScreen(
    notesScreenViewModel: NotesScreenViewModel
) {
    val colorScheme = MaterialTheme.colorScheme
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerLayout(
                notesScreenViewModel = notesScreenViewModel
            )
        }
    ) {
        Scaffold(
            topBar = {
                NotesScreenTopAppBar(drawerState = drawerState)
            }
        ) { paddingValues ->
            Modifier.padding(paddingValues)
        }
    }


}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun NotesScreenPreview() {
    NotesScreen(
        notesScreenViewModel = NotesScreenViewModel()
    )
}