package com.example.adt_notes.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.R
import com.example.adt_notes.data.models.NotesType
import com.example.adt_notes.data.navigation.NotesRoutes
import com.example.adt_notes.presentation.screens.main.botttom_navigation.notes.NotesScreenViewModel
import com.example.adt_notes.presentation.theme.NotesTypeBlue
import com.example.adt_notes.presentation.theme.NotesTypeGrey
import com.example.adt_notes.presentation.theme.NotesTypeRed
import com.example.adt_notes.presentation.theme.NotesTypeYellow
import com.example.adt_notes.presentation.theme.NunitoSansFamily

val items = listOf(
    NotesType(
        route = NotesRoutes.ALL,
        name = "All Notes",
        accentColor = NotesTypeGrey,
        iconResId = R.drawable.all_notes
    ),
    NotesType(
        route = NotesRoutes.FAVOURITE,
        name = "Favourites",
        accentColor = NotesTypeYellow,
        iconResId = R.drawable.favourite_notes
    ),
    NotesType(
        route = NotesRoutes.HIDDEN,
        name = "Hidden",
        accentColor = NotesTypeBlue,
        iconResId = R.drawable.hidden_notes
    ),
    NotesType(
        route = NotesRoutes.TRASH,
        name = "Trash",
        accentColor = NotesTypeRed,
        iconResId = R.drawable.trash
    ),
)

@Composable
fun DrawerLayout(
    notesScreenViewModel: NotesScreenViewModel
) {
    val colorScheme = MaterialTheme.colorScheme
    ModalDrawerSheet(
        modifier = Modifier.width(220.dp),
        drawerContainerColor = colorScheme.secondary
    ) {
        Column(
            Modifier.padding(horizontal = 25.dp)
        ) {
            Text(
                text = "Select note's type:",
                style = TextStyle(
                    fontFamily = NunitoSansFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorScheme.onBackground
                ),
                modifier = Modifier.padding(start = 3.dp)
            )
            Spacer(Modifier.height(15.dp))
            items.forEach { item ->
                NotesTypeCard(
                    notesType = item,
                    onClick = {
                        notesScreenViewModel.changeState(
                            notesRoute = item.route
                        )
                    },
                    isSelected = item.route == notesScreenViewModel.state.notesRoute
                )
            }
        }
    }
}