package com.example.adt_notes.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.R
import com.example.adt_notes.data.models.BottomNavigationItemModel
import com.example.adt_notes.domain.navigation.bottom.BottomNavRoutes
import com.example.adt_notes.ui.screens.main.botttom_navigation.ProfileScreen
import com.example.adt_notes.ui.theme.NunitoSansFamily

@Composable
fun BottomNavigationItem(
    item: BottomNavigationItemModel,
    navigateToItemScreen: () -> Unit,
    isSelected: Boolean
) {
    val colorScheme = MaterialTheme.colorScheme
    val itemAccentColor = if (isSelected) {
        colorScheme.primary
    } else {
        colorScheme.onBackground
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentWidth()
            .height(80.dp)
    ) {
        IconButton(
            onClick = { navigateToItemScreen() }
        ) {
            Icon(
                painter = painterResource(item.icon),
                contentDescription = null,
                modifier = Modifier.width(21.dp),
                tint = itemAccentColor
            )
        }
        Text(
            text = item.name,
            style = TextStyle(
                fontFamily = NunitoSansFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 9.sp,
                color = itemAccentColor
            ),
            modifier = Modifier
                .clickable { navigateToItemScreen() }
        )
    }
}

@Preview
@Composable
private fun BottomNavigationItemPreview() {
    BottomNavigationItem(
        item = BottomNavigationItemModel(
            route = BottomNavRoutes.NOTES.route,
            name = "Notes",
            icon = R.drawable.notes
        ),
        navigateToItemScreen = {},
        isSelected = true
    )
}