package com.example.bankapp.mock.repository

import com.example.bankapp.domain.model.Account
import com.example.bankapp.domain.model.Category
import com.example.bankapp.domain.model.Transaction
import com.example.bankapp.domain.repository.Repository
import java.time.LocalDate

import java.time.LocalDateTime
import java.time.YearMonth

class MockRepository : Repository {

    private val mockTransactions = listOf(
        Transaction(
            id = 1,
            accountId = 1,
            categoryId = 4,
            amount = 5100.0,
            transactionDate = LocalDateTime.now(),
            comment = "Покупка еды",
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        ),
        Transaction(
            id = 2,
            accountId = 1,
            categoryId = 3,
            amount = 1200.0,
            transactionDate = LocalDateTime.now().minusDays(20),
            comment = "Куртка",
            createdAt = LocalDateTime.now().minusDays(20),
            updatedAt = LocalDateTime.now().minusDays(19)
        ),
        Transaction(
            id = 3,
            accountId = 2,
            categoryId = 1,
            amount = 3000.0,
            transactionDate = LocalDateTime.now(),
            comment = "Зарплата",
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        ),
        Transaction(
            id = 4,
            accountId = 1,
            categoryId = 4,
            amount = 750.0,
            transactionDate = LocalDateTime.now(),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        ),
        Transaction(
            id = 5,
            accountId = 1,
            categoryId = 5,
            amount = 300.0,
            transactionDate = LocalDateTime.now(),
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        ),
        Transaction(
            id = 6,
            accountId = 1,
            categoryId = 1,
            amount = 3050.0,
            transactionDate = LocalDateTime.now(),
            comment = "Ремонт крана",
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    )


    override suspend fun getAccounts(): List<Account> {
        return listOf(
            Account(
                id = 1,
                userId = 1,
                name = "Основной счёт",
                balance = 100000.0,
                currency = "RUB",
                createdAt = LocalDateTime.now().minusDays(10),
                updatedAt = LocalDateTime.now()
            ),
            Account(
                id = 2,
                userId = 1,
                name = "USD Счёт",
                balance = 2500.0,
                currency = "USD",
                createdAt = LocalDateTime.now().minusDays(30),
                updatedAt = LocalDateTime.now()
            )
        )
    }

    override suspend fun getCategories(): List<Category> {
        return listOf(

            Category(id = 1, name = "Зарплата", emoji = "💰", isIncome = true),
            Category(id = 2, name = "Фриланс", emoji = "🧑‍💻", isIncome = true),
            Category(id = 3, name = "Подарок", emoji = "🎁", isIncome = true),


            Category(id = 4, name = "Продукты", emoji = "🍎", isIncome = false),
            Category(id = 5, name = "Кафе", emoji = "☕", isIncome = false),
            Category(id = 6, name = "Транспорт", emoji = "🚗", isIncome = false),
            Category(id = 7, name = "Одежда", emoji = "👕", isIncome = false),
            Category(id = 8, name = "Развлечения", emoji = "🎮", isIncome = false),
            Category(id = 9, name = "Медицина", emoji = "💊", isIncome = false),
            Category(id = 10, name = "Аренда", emoji = "🏠", isIncome = false),
            Category(id = 11, name = "Ремонт квартиры", emoji = "рк", isIncome = false)
        )
    }

    override suspend fun getTransactionsByAccount(
        accountId: Int,
        startDate: LocalDate?,
        endDate: LocalDate?
    ): List<Transaction> {
        val start = startDate ?: YearMonth.now().atDay(1)
        val end = endDate ?: YearMonth.now().atEndOfMonth()

        return mockTransactions.filter {
            it.accountId == accountId &&
                    it.transactionDate.toLocalDate() in start..end
        }
    }
}
