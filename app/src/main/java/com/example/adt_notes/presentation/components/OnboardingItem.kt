package com.example.adt_notes.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.data.models.Onboarding
import com.example.adt_notes.presentation.screens.onboarding.OnboardingScreenViewModel
import com.example.adt_notes.presentation.theme.NunitoSansFamily

@Composable
fun OnboardingItem(
    modifier: Modifier = Modifier,
    onboarding: Onboarding
) {
    val colorScheme = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(onboarding.imagesResId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(40.dp))
        Text(
            text = onboarding.title,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = NunitoSansFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 33.sp,
                color = colorScheme.onBackground
            )
        )
        Spacer(Modifier.height(30.dp))
        Text(
            text = onboarding.comment,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontFamily = NunitoSansFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = colorScheme.onBackground.copy(alpha = 0.8f)
            ),
        )
    }
}