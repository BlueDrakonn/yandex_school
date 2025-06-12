package com.example.bankapp.domain.repository

import com.example.bankapp.domain.model.Account
import com.example.bankapp.domain.model.Category
import com.example.bankapp.domain.model.Transaction
import java.time.LocalDate

interface Repository {
    suspend fun getAccounts(): List<Account>
    suspend fun getCategories(): List<Category>
    suspend fun getTransactionsByAccount(
        accountId: Int,
        startDate: LocalDate? = null,
        endDate: LocalDate? = null
    ): List<Transaction>
}
