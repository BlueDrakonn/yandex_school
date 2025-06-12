package com.example.bankapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bankapp.domain.viewmodel.MainViewModel
import com.example.bankapp.ui.navigation.AppNavigation
import com.example.bankapp.ui.theme.BankAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = MainViewModel()

        enableEdgeToEdge()
        setContent {
            BankAppTheme {
                AppNavigation(viewModel)
            }
        }
    }
}

