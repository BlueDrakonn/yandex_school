package com.example.bankapp.domain.model

data class AccountState(
    val id: Int,
    val name: String,
    val balance: Double,
    val currency: String
)
