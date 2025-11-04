package com.example.adt_notes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import com.example.adt_notes.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.adt_notes.data.models.BottomNavigationItemModel
import com.example.adt_notes.data.navigation.BottomNavRoutes

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {
    val colorScheme = MaterialTheme.colorScheme
    val items = listOf(
        BottomNavigationItemModel(
            route = BottomNavRoutes.NOTES.route,
            name = "Notes",
            icon = R.drawable.notes
        ),
        BottomNavigationItemModel(
            route = BottomNavRoutes.CREATE_NOTE.route,
            name = "Create note",
            icon = R.drawable.create_note
        ),
        BottomNavigationItemModel(
            route = BottomNavRoutes.PROFILE.route,
            name = "Profile",
            icon = R.drawable.profile
        ),
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(horizontal = 8.dp, vertical = 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(colorScheme.secondary),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            val isSelected = currentRoute == item.route
            BottomNavigationItem(
                item = item,
                navigateToItemScreen = { navController.navigate(item.route) },
                isSelected = isSelected
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        navController = rememberNavController()
    )
}