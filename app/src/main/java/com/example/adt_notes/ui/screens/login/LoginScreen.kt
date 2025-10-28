package com.example.adt_notes.ui.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.ui.components.AppAlertDialog
import com.example.adt_notes.ui.components.AppBigButton
import com.example.adt_notes.ui.components.AppOutlinedTextField
import com.example.adt_notes.ui.theme.NunitoSansFamily

@Composable
fun LoginScreen(
    vm: LoginScreenViewModel
) {
    val colorScheme = MaterialTheme.colorScheme
    val state = vm.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(0.2f))
        Text(
            text = "Login",
            style = TextStyle(
                fontFamily = NunitoSansFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
                color = colorScheme.onBackground
            ),
            modifier = Modifier.weight(0.2f)
        )
        Spacer(Modifier.height(40.dp))
        Column(
            Modifier.fillMaxWidth().padding(horizontal = 20.dp).weight(0.6f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppOutlinedTextField(
                value = state.login,
                onValueChange = { newLogin ->
                    vm.changeState(login = newLogin)
                },
                placeholderText = "Login"
            )
            Spacer(Modifier.height(30.dp))
            AppOutlinedTextField(
                value = state.password,
                onValueChange = { newPassword ->
                    vm.changeState(password = newPassword)
                },
                placeholderText = "Password"
            )
            Spacer(Modifier.height(50.dp))
            AppBigButton(
                onClick = { vm.buttonNextPressed() },
                text = "Next"
            )
        }

    }
    if (state.isError) {
        AppAlertDialog(
            onDismissRequest = { vm.changeState(
                isError = false,
                errorString = ""
            ) },
            onConfirmation = { vm.changeState(
                isError = false,
                errorString = ""
            ) },
            dialogTitle = "That's an error",
            dialogText = state.errorString
        )
    }

}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        LoginScreenViewModel()
    )
}