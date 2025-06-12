package com.example.bankapp.domain.viewmodel

import com.example.bankapp.domain.model.AccountHistory

data class AccountHistoryResponse(
    val accountId: Int,
    val accountName: String,
    val currency: String,
    val currentBalance: Double,
    val history: List<AccountHistory>
)