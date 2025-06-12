package com.example.bankapp.ui.model

data class Expense (
    val id: Int,
    val title: String,
    val subtitle: String? = null,
    val icon: String,
    val amount: Double,
    val currency: String
)
