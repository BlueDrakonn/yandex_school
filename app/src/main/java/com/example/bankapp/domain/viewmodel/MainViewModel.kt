package com.example.bankapp.domain.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankapp.domain.model.Account
import com.example.bankapp.domain.model.Category
import com.example.bankapp.data.model.TransactionResponse
import com.example.bankapp.mock.repository.MockRepository
import com.example.bankapp.domain.model.Transaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(

) : ViewModel() {

    private val repository = MockRepository() //не совсем корректно, но пока все равно mock данные


    private val _totalIncome = MutableStateFlow(0.0)
    val totalIncome: StateFlow<Double> = _totalIncome

    private val _totalExpense = MutableStateFlow(0.0)
    val totalExpense: StateFlow<Double> = _totalExpense

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    private val _accounts = MutableStateFlow<List<Account>>(emptyList())
    val accounts: StateFlow<List<Account>> = _accounts

    private val _incomeTransactions = MutableStateFlow<List<Transaction>>(emptyList())
    val incomeTransactions: StateFlow<List<Transaction>> = _incomeTransactions

    private val _expenseTransactions = MutableStateFlow<List<Transaction>>(emptyList())
    val expenseTransactions: StateFlow<List<Transaction>> = _expenseTransactions

    init {
        viewModelScope.launch {
            val loadedCategories = repository.getCategories()
            _categories.value = loadedCategories

            val loadedAccounts = repository.getAccounts()
            _accounts.value = loadedAccounts

            val firstAccountId = loadedAccounts.firstOrNull()?.id

            if (firstAccountId != null) {
                val todayTransactions = repository.getTodayTransactionsByAccount(firstAccountId)
                val incomeList = mutableListOf<Transaction>()
                val expenseList = mutableListOf<Transaction>()

                todayTransactions.forEach { transaction ->
                    val uiModel = transaction.toUi()
                    if (transaction.category.isIncome) {
                        incomeList.add(uiModel)

                    } else {
                        expenseList.add(uiModel)
                    }
                }
                Log.d("firstAccountId","$incomeList")
                _incomeTransactions.value = incomeList
                _expenseTransactions.value = expenseList

                _totalIncome.value = incomeList.sumOf { it.amount }
                _totalExpense.value = expenseList.sumOf { it.amount }
            }
        }
    }


}


fun TransactionResponse.toUi(): Transaction {
    return Transaction(
        id = id,
        title = category.title,
        subtitle = comment,
        icon = category.icon,
        amount = amount,
        currency = account.currency
    )
}
