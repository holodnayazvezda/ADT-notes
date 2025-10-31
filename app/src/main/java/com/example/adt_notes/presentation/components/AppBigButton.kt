package com.example.adt_notes.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.presentation.theme.NunitoSansFamily

@Composable
fun AppBigButton(
    onClick: () -> Unit,
    text: String
) {
    val colorScheme = MaterialTheme.colorScheme
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = NunitoSansFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = colorScheme.background
            )
        )
    }
}