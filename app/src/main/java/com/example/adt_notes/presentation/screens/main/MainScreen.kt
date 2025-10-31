package com.example.adt_notes.presentation.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.adt_notes.presentation.components.BottomNavigationBar
import com.example.adt_notes.presentation.navigation.BottomNavGraph

@Composable
fun MainScreen(
    bottomNavController: NavHostController
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = bottomNavController) }
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