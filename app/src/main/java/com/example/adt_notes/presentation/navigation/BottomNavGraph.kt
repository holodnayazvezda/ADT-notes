package com.example.adt_notes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.adt_notes.data.navigation.BottomNavRoutes
import com.example.adt_notes.presentation.screens.main.botttom_navigation.CreateNoteScreen
import com.example.adt_notes.presentation.screens.main.botttom_navigation.NotesScreen
import com.example.adt_notes.presentation.screens.main.botttom_navigation.ProfileScreen

@Composable
fun BottomNavGraph(
    modifier: Modifier,
    bottomNavController: NavHostController,
    startDestination: String = BottomNavRoutes.NOTES.route,
) {
    NavHost(
        navController = bottomNavController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(BottomNavRoutes.NOTES.route) {
            NotesScreen()
        }
        composable(BottomNavRoutes.CREATE_NOTE.route) {
            CreateNoteScreen()
        }
        composable(BottomNavRoutes.PROFILE.route) {
            ProfileScreen()
        }
    }
}