package com.example.adt_notes.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.ui.theme.NunitoSansFamily

@Composable
fun AppOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String
) {
    val colorScheme = MaterialTheme.colorScheme

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = colorScheme.onBackground,
            focusedBorderColor = colorScheme.primary,
            unfocusedTextColor = colorScheme.onSecondary,
            focusedTextColor = colorScheme.onBackground,
            cursorColor = colorScheme.primary,
            unfocusedLabelColor = colorScheme.onBackground.copy(alpha = 0.7f),
            focusedLabelColor = colorScheme.primary
        ),
        singleLine = true,
        textStyle = TextStyle(
            fontFamily = NunitoSansFamily,
            fontSize = 18.sp
        ),
        shape = RoundedCornerShape(15.dp),
        label = {
            Text(
                text = placeholderText,
                style = TextStyle(
                    fontFamily = NunitoSansFamily,
                    fontSize = 18.sp
                )
            )
        }
    )
}