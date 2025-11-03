package com.example.adt_notes.data.storage

import android.content.Context

private const val SharedPreferenceName = "auth_preferences"
private const val AccessToken = "access_token"
private const val OnboardingPage = "onboarding_page"
private const val WatchedOnboarding = "watched_onboarding"


class AuthStorage(context: Context): Storage(context, SharedPreferenceName) {
    var accessToken: String?
        get() {
            val storedUsername = getString(AccessToken)
            return storedUsername
        }
        set(value) {
            putString(AccessToken, value)
        }

    var onboardingPage: Int
        get() {
            return getInteger(OnboardingPage)
        }
        set(value) {
            putInteger(OnboardingPage, value)
            if (value == 2) {
                watchedOnboarding = true
            }
        }

    var watchedOnboarding: Boolean
        get() {
            return getBoolean(WatchedOnboarding)
        }
        set(value) {
            putBoolean(WatchedOnboarding, value)
        }

    fun clearAuthData() {
        delete(AccessToken)
        delete(OnboardingPage)
        delete(WatchedOnboarding)
    }
}