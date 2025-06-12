package com.example.bankapp.ui.screen

import ListItem
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bankapp.R
import com.example.bankapp.ui.common.LeadIcon
import com.example.bankapp.ui.common.PriceDisplay
import com.example.bankapp.ui.model.Expense

@Composable
fun ExpensesScreen() {

    val mock = listOf(
        Expense(
            id = 1,
            title = "квартира",
            subtitle = "ремонт",
            icon = "💰",
            amount = 12000.0,
            currency = "₽"
        ),
        Expense(
            id = 2,
            title = "Кофе",
            subtitle = "1 чашка",
            icon = "☕",
            amount = 500.0,
            currency = "₽"
        ),
        Expense(
            id = 3,
            title = "Кофе",
            icon = "жж",
            amount = 501110.0,
            currency = "₽"
        )


    )


    val totalAmount = remember { mock.sumOf { it.amount } }

    Column {
        Row {
            ListItem(
                modifier = Modifier.background(MaterialTheme.colorScheme.secondary),
                content = {
                    Text(
                        text = stringResource(R.string.totalAmount_subtitle),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                trailingContent = {
                    PriceDisplay(
                        amount = totalAmount,
                        currencySymbol = mock[0].currency //пока мок версия
                    )
                },
            )
        }
        HorizontalDivider()
        LazyColumn {
            items(
                items = mock,
                key = { it.id }
            ) { item ->
                ListItem(
                    modifier = Modifier.height(68.dp),
                    lead = {LeadIcon(label = item.icon)},
                    content = {
                        Column(
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                            if (item.subtitle != null) {
                                Text(
                                    text = item.subtitle,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSecondary
                                )
                            }
                        }
                    },
                    trailingContent = {
                        PriceDisplay(
                            amount = item.amount,
                            currencySymbol = item.currency
                        )
                    },
                    trailIcon = {
                        Icon(painter = painterResource(R.drawable.drillin),
                            contentDescription = null,

                            )}
                )


            }
        }
    }


}

