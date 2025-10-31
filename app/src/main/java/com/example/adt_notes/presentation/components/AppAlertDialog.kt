package com.example.adt_notes.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun AppAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String
) {
    val colorScheme = MaterialTheme.colorScheme
    
    AlertDialog(
        title = {
            Text(
                text = dialogTitle
            )
        },
        text = {
            Text(
                text = dialogText
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(
                    text = "ОК",
                    color = colorScheme.onBackground,
                    fontSize = 15.sp
                )
            }
        },
        containerColor = colorScheme.secondary,
        titleContentColor = colorScheme.primary,
        textContentColor = colorScheme.onBackground,
        iconContentColor = colorScheme.onBackground,
    )
}