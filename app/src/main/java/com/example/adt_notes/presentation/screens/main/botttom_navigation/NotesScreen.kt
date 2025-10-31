package com.example.adt_notes.presentation.screens.main.botttom_navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.adt_notes.presentation.components.notes_screen_top_up_bar.NotesScreenTopAppBar

@Composable
fun NotesScreen() {
    val colorScheme = MaterialTheme.colorScheme
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column {
                    Text(
                        text = "Эщькере"
                    )
                }
            }
        }
    ) {
        NotesScreenTopAppBar(
            drawerState = drawerState
        )
    }


}

@Preview
@Composable
private fun NotesScreenPreview() {
    NotesScreen()
}