package com.example.adt_notes.presentation.screens.onboarding

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adt_notes.presentation.components.OnboardingButtonRow
import com.example.adt_notes.presentation.components.OnboardingItem
import com.example.adt_notes.presentation.components.AppBigButton


import com.example.adt_notes.presentation.theme.NunitoSansFamily
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    vm: OnboardingScreenViewModel,
    nextScreen: () -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = vm.onboardingPageNumber.intValue,
        pageCount = { vm.onboardingModel.size }
    )
    val colorScheme = MaterialTheme.colorScheme
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pagerState.currentPage) {
        vm.updateOnboardingPageNumber(pagerState.currentPage)
    }

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(0.8f)
                .fillMaxWidth()
        ) { page ->
            OnboardingItem(
                onboarding = vm.onboardingModel[page]
            )
        }

        Column(
            Modifier
                .fillMaxWidth()
                .weight(0.15f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedContent(
                targetState = pagerState.currentPage == 0,
                transitionSpec = {
                    (scaleIn(
                        animationSpec = tween(350),
                        initialScale = 0.8f
                    ) + fadeIn(tween(350))) togetherWith
                            (scaleOut(
                                animationSpec = tween(300),
                                targetScale = 0.8f
                            ) + fadeOut(tween(300)))
                },
                label = "button_animation"
            ) { isFirstPage ->
                if (isFirstPage) {
                    AppBigButton(
                        onClick = {
                            coroutineScope.launch {
                                if (pagerState.currentPage < pagerState.pageCount - 1) {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                } else {
                                    nextScreen()
                                }
                            }
                        },
                        text = if (pagerState.currentPage < pagerState.pageCount - 1) "Next" else "Get Started"
                    )
                } else {
                    OnboardingButtonRow(
                        onNext = {
                            coroutineScope.launch {
                                if (pagerState.currentPage < pagerState.pageCount - 1) {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                } else {
                                    nextScreen()
                                }
                            }
                        },
                        onBack = {
                            coroutineScope.launch {
                                if (pagerState.currentPage > 0) {
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }
                            }
                        },
                        isLast = pagerState.currentPage == pagerState.pageCount - 1
                    )
                }
            }

            Spacer(Modifier.height(15.dp))

            AnimatedVisibility(
                visible = pagerState.currentPage != pagerState.pageCount - 1,
                enter = scaleIn(
                    animationSpec = tween(350),
                    initialScale = 0.8f
                ) + fadeIn(tween(350)),
                exit = scaleOut(
                    animationSpec = tween(300),
                    targetScale = 0.8f
                ) + fadeOut(tween(300))
            ) {
                Text(
                    text = "Skip onboarding",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = NunitoSansFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = colorScheme.primary.copy(alpha = 0.9f)
                    ),
                    modifier = Modifier.clickable {
                        nextScreen()
                    }
                )
            }
        }
    }
}