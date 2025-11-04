package com.example.adt_notes.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adt_notes.data.navigation.NavRoutes
import com.example.adt_notes.presentation.screens.login.LoginScreen
import com.example.adt_notes.presentation.screens.login.LoginScreenViewModel
import com.example.adt_notes.presentation.screens.main.MainScreen
import com.example.adt_notes.presentation.screens.main.botttom_navigation.notes.NotesScreenViewModel
import com.example.adt_notes.presentation.screens.onboarding.OnboardingScreen
import com.example.adt_notes.presentation.screens.onboarding.OnboardingScreenViewModel
import com.example.adt_notes.presentation.screens.register.RegisterScreen
import com.example.adt_notes.presentation.screens.register.RegisterScreenViewModel
import com.example.adt_notes.presentation.screens.splash.SplashScreen
import com.example.adt_notes.presentation.screens.splash.SplashScreenViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    startDestination: String = NavRoutes.SPLASH.route,
    navHostController: NavHostController = rememberNavController(),
    bottomNavHostController: NavHostController = rememberNavController()
) {
    val onboardingScreenViewModel : OnboardingScreenViewModel = koinViewModel()
    val splashScreenViewModel : SplashScreenViewModel = koinViewModel(
        parameters = {
            parametersOf(
                { navHostController.navigate(NavRoutes.ONBOARDING.route) },
                { navHostController.navigate(NavRoutes.LOGIN.route) },
                { navHostController.navigate(NavRoutes.REGISTER.route) },
                { navHostController.navigate(NavRoutes.MAIN.route) }
            )
        }
    )
    val loginScreenViewModel: LoginScreenViewModel = koinViewModel(
        parameters = {
            parametersOf(
                { navHostController.navigate(NavRoutes.MAIN.route) }
            )
        }
    )
    val registerScreenViewModel: RegisterScreenViewModel = koinViewModel(
        parameters = {
            parametersOf(
                { navHostController.navigate(NavRoutes.MAIN.route) }
            )
        }
    )
    val notesScreenViewModel : NotesScreenViewModel = koinViewModel()

    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(NavRoutes.SPLASH.route) {
            SplashScreen(
                vm = splashScreenViewModel
            )
        }
        composable(NavRoutes.ONBOARDING.route) {
            OnboardingScreen(
                vm = onboardingScreenViewModel,
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
                }
            )
        }

        composable(NavRoutes.REGISTER.route) {
            RegisterScreen(
                vm = registerScreenViewModel,
                navigateToLoginScreen = {
                    navHostController.navigate(NavRoutes.LOGIN.route)
                }
            )
        }

        composable(NavRoutes.MAIN.route) {
            MainScreen(
                bottomNavController = bottomNavHostController,
                notesScreenViewModel = notesScreenViewModel
            )
        }
    }
}