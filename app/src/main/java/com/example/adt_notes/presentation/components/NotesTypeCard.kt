package com.example.adt_notes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.data.models.NotesType
import com.example.adt_notes.presentation.theme.NunitoSansFamily

@Composable
fun NotesTypeCard(
    notesType: NotesType,
    onClick: () -> Unit,
    isSelected: Boolean
) {
    val colorScheme = MaterialTheme.colorScheme
    Column {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (isSelected) {
                        notesType.accentColor
                    } else {
                        colorScheme.background
                    }
                ).clickable {
                    onClick()
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(notesType.accentColor),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(notesType.iconResId),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = colorScheme.background
                    )
                }
                Text(
                    text = notesType.name,
                    style = TextStyle(
                        fontFamily = NunitoSansFamily,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (isSelected) {
                            colorScheme.background
                        } else {
                            colorScheme.onBackground
                        }
                    )
                )
            }
        }
        Spacer(Modifier.height(15.dp))
    }
}