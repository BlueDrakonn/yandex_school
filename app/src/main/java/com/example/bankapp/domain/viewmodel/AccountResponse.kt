package com.example.bankapp.domain.viewmodel

import com.example.bankapp.domain.model.StatItem
import java.time.LocalDateTime

data class AccountResponse(
    val id: Int,
    val name: String,
    val balance: Double,
    val currency: String,
    val incomeStats: List<StatItem>,
    val expenseStats: List<StatItem>,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
