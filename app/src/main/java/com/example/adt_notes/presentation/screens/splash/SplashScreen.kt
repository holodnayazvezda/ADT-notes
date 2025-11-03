package com.example.adt_notes.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.R
import com.example.adt_notes.presentation.theme.NunitoSansFamily
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    vm: SplashScreenViewModel
) {
    val colorScheme = MaterialTheme.colorScheme

    LaunchedEffect(Unit) {
        delay(200)

        vm.navigateToNextScreen()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.adt),
                contentDescription = null,
                modifier = Modifier.size(200.dp).clip(CircleShape)
            )
            Spacer(Modifier.height(30.dp))
            Text(
                text = stringResource(R.string.app_name),
                style = TextStyle(
                    fontFamily = NunitoSansFamily,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorScheme.primary
                )
            )
        }
    }
}