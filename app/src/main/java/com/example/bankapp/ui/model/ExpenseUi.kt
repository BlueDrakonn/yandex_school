package com.example.bankapp.ui.model

data class ExpenseUi (
    val id: Int,
    val title: String,
    val subtitle: String? = null,
    val icon: String,
    val amount: Double,
    val currency: String
)
