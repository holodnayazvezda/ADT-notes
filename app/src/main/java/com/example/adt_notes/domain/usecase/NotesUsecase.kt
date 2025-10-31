package com.example.adt_notes.domain.usecase

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class NotesUsecase {
    fun getFormatedSystemDate(): String {
        val today: LocalDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy", Locale.ENGLISH)
        return today.format(formatter)
    }
}