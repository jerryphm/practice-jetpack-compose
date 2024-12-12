package com.example.myapplication.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Brush

data class Card(
    @DrawableRes val icon: Int,
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val balance: Double,
    val color: Brush
)
