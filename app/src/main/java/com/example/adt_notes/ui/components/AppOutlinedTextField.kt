package com.example.adt_notes.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.R
import com.example.adt_notes.ui.theme.NunitoSansFamily

@Composable
fun AppOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    withTextHiding: Boolean = false
) {
    val colorScheme = MaterialTheme.colorScheme
    var hideText by remember { mutableStateOf(true) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = colorScheme.onBackground,
            focusedBorderColor = colorScheme.primary,
            unfocusedTextColor = colorScheme.onBackground.copy(alpha = 0.7f),
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
        },
        trailingIcon = {
            if (withTextHiding) {
                IconButton(
                    onClick = {
                        hideText = !hideText
                    }
                ) {
                    Icon(
                        painter = painterResource(
                            id = if (hideText) { R.drawable.eye }
                            else { R.drawable.eye_crossed }
                        ),
                        contentDescription = null,
                        tint = colorScheme.onBackground,
                        modifier = Modifier.size(17.dp)
                    )
                }
            }
        },
        visualTransformation = if (withTextHiding && hideText) {
            PasswordVisualTransformation('●')
        } else {
            VisualTransformation.None
        }
    )
}
