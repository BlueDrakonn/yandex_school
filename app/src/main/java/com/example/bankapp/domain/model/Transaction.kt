package com.example.bankapp.domain.model

import java.time.LocalDateTime

data class Transaction(
    val id: Int,
    val accountId: Int,
    val categoryId: Int,
    val amount: Double,
    val transactionDate: LocalDateTime,
    val comment: String? = null,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
