package com.example.adt_notes.domain.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adt_notes.ui.screens.login.LoginScreen
import com.example.adt_notes.ui.screens.login.LoginScreenViewModel
import com.example.adt_notes.ui.screens.main.MainScreen
import com.example.adt_notes.ui.screens.onboarding.OnboardingScreen
import com.example.adt_notes.ui.screens.register.RegisterScreen
import com.example.adt_notes.ui.screens.register.RegisterScreenViewModel

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    startDestination: String = NavRoutes.ONBOARDING.route,
    navHostController: NavHostController = rememberNavController(),
    loginScreenViewModel: LoginScreenViewModel = LoginScreenViewModel(),
    registerScreenViewModel: RegisterScreenViewModel = RegisterScreenViewModel()
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(NavRoutes.ONBOARDING.route) {
            OnboardingScreen(
                nextScreen = {
                    navHostController.navigate(NavRoutes.LOGIN.route)
                }
            )
        }

        composable(NavRoutes.LOGIN.route) {
            LoginScreen(
                vm = loginScreenViewModel,
                navigateToRegisterScreen = {
                    navHostController.navigate(NavRoutes.REGISTER.route)
                },
                navigateToMainScreen = {
                    navHostController.navigate(NavRoutes.MAIN.route)
                }
            )
        }

        composable(NavRoutes.REGISTER.route) {
            RegisterScreen(
                vm = registerScreenViewModel,
                navigateToLoginScreen = {
                    navHostController.navigate(NavRoutes.LOGIN.route)
                },
                navigateToMainScreen = {
                    navHostController.navigate(NavRoutes.MAIN.route)
                }
            )
        }

        composable(NavRoutes.MAIN.route) {
            MainScreen()
        }
    }
}