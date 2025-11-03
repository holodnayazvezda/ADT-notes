package com.example.adt_notes.data.storage


import android.content.Context
import androidx.core.content.edit


open class Storage(context: Context, sharedPreferenceName: String) {
    private val prefs = context.getSharedPreferences(
        sharedPreferenceName,
        Context.MODE_PRIVATE
    )

    fun getString(key: String): String? {
        return prefs.getString(key, "")
    }

    fun putString(key: String, value: String?) {
        prefs.edit {
            putString(key, value)
        }
    }

    fun getInteger(key: String): Int {
        return prefs.getInt(key, 0)
    }

    fun putInteger(
        key: String,
        value: Int
    ) {
        prefs.edit {
            putInt(key, value)
        }
    }

    fun getBoolean(key: String): Boolean {
        return prefs.getBoolean(key, false)
    }

    fun putBoolean(key: String, value: Boolean) {
        prefs.edit {
            putBoolean(key, value)
        }
    }

    fun delete(key: String) {
        prefs.edit { remove(key) }
    }
}