package com.example.adt_notes.presentation.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.adt_notes.presentation.components.BottomNavigationBar
import com.example.adt_notes.presentation.components.DrawerLayout
import com.example.adt_notes.presentation.components.notes_screen_top_up_bar.NotesScreenTopAppBar
import com.example.adt_notes.presentation.navigation.BottomNavGraph
import com.example.adt_notes.presentation.screens.main.botttom_navigation.notes.NotesScreenViewModel

@Composable
fun MainScreen(
    bottomNavController: NavHostController,
    notesScreenViewModel: NotesScreenViewModel
) {
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
            },
            bottomBar = {
                BottomNavigationBar(navController = bottomNavController)
            }
        ) { paddingValues ->
            BottomNavGraph(
                modifier = Modifier.padding(paddingValues),
                bottomNavController = bottomNavController,
                notesScreenViewModel = notesScreenViewModel
            )
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(
        bottomNavController = rememberNavController(),
        notesScreenViewModel = NotesScreenViewModel()
    )
}