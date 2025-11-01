package com.example.adt_notes.presentation.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.adt_notes.presentation.components.BottomNavigationBar
import com.example.adt_notes.presentation.components.notes_screen_top_up_bar.NotesScreenTopAppBar
import com.example.adt_notes.presentation.navigation.BottomNavGraph

@Composable
fun MainScreen(
    bottomNavController: NavHostController
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = bottomNavController) },
        topBar = {
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
    ) { paddingValues ->
        BottomNavGraph(
            modifier = Modifier.padding(paddingValues),
            bottomNavController = bottomNavController
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(
        bottomNavController = rememberNavController()
    )
}