package com.example.adt_notes.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.R
import com.example.adt_notes.presentation.theme.NunitoSansFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreenTopAppBar(
    drawerState: DrawerState
) {
    val colorScheme = MaterialTheme.colorScheme
    val scope = rememberCoroutineScope()

    TopAppBar(
        title = {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = TextStyle(
                        fontFamily = NunitoSansFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    )
                )
                Spacer(Modifier.height(5.dp))
                Text(
                    text = "22 December, 2021",
                    style = TextStyle(
                        fontFamily = NunitoSansFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp
                    )
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                }
            ) {
                Icon(
                    painterResource(R.drawable.left_menu_buttons),
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                    tint = colorScheme.primary
                )
            }
        }
    )
}

@Preview
@Composable
private fun NotesScreenTopAppBarPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    NotesScreenTopAppBar(
        drawerState
    )
}