package com.example.adt_notes.ui.theme

import com.example.adt_notes.R

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val NunitoSansFamily = FontFamily(
    Font(
        R.font.nunito_sans_extra_light,
        FontWeight.ExtraLight,
        FontStyle.Normal
    ),
    Font(
        R.font.nunito_sans_extra_light_italic,
        FontWeight.ExtraLight,
        FontStyle.Italic
    ),
    Font(
        R.font.nunito_sans_light,
        FontWeight.Light,
        FontStyle.Normal
    ),
    Font(
        R.font.nunito_sans_light_italic,
        FontWeight.Light,
        FontStyle.Italic
    ),
    Font(
        R.font.nunito_sans_regular,
        FontWeight.Normal,
        FontStyle.Normal
    ),
    Font(
        R.font.nunito_sans_italic,
        FontWeight.Normal,
        FontStyle.Italic
    ),
    Font(
        R.font.nunito_sans_semi_bold,
        FontWeight.SemiBold,
        FontStyle.Normal
    ),
    Font(
        R.font.nunito_sans_semi_bold_italic,
        FontWeight.SemiBold,
        FontStyle.Italic
    ),
    Font(
        R.font.nunito_sans_bold,
        FontWeight.Bold,
        FontStyle.Normal
    ),
    Font(
        R.font.nunito_sans_bold_italic,
        FontWeight.Bold,
        FontStyle.Italic
    ),
    Font(
        R.font.nunito_sans_extra_bold,
        FontWeight.ExtraBold,
        FontStyle.Normal
    ),
    Font(
        R.font.nunito_sans_extra_bold_italic,
        FontWeight.ExtraBold,
        FontStyle.Italic
    ),
    Font(
        R.font.nunito_sans_black,
        FontWeight.Black,
        FontStyle.Normal
    ),
    Font(
        R.font.nunito_sans_black_italic,
        FontWeight.Black,
        FontStyle.Italic
    )
)


val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = NunitoSansFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
)