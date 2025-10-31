package com.example.adt_notes.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.R
import com.example.adt_notes.presentation.theme.NunitoSansFamily

@Composable
fun OnboardingButtonRow(
    onNext: () -> Unit,
    onBack: () -> Unit,
    isLast: Boolean
) {
    val colorScheme = MaterialTheme.colorScheme
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onNext,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .weight(0.72f),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = if (isLast) "Get Started" else "Next",
                style = TextStyle(
                    fontFamily = NunitoSansFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = colorScheme.background
                )
            )
        }
        Spacer(Modifier.weight(0.08f))
        IconButton(
            onClick = onBack,
            modifier = Modifier
                .height(56.dp)
                .weight(0.2f),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = colorScheme.primary.copy(alpha = 0.7f)
            )
        ) {
            Icon(
                painter = painterResource(R.drawable.outline_arrow_back_24),
                contentDescription = null,
                tint = colorScheme.background
            )
        }
    }
}
