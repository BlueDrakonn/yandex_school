package com.example.bankapp.ui.screen

import ListItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
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
import com.example.bankapp.ui.common.LazyList
import com.example.bankapp.ui.common.PriceDisplay
import com.example.bankapp.ui.model.IncomeUi

@Composable
fun IncomeScreen() {

    val mock = listOf(
        IncomeUi(
            id = 1,
            title = "зарплата",
            amount = 420000.0,
            currency = "₽"
        ),
        IncomeUi(
            id = 2,
            title = "подработка",
            amount = 10000.0,
            currency = "₽"
        ),
        IncomeUi(
            id = 3,
            title = "подарок",
            amount = 777.0,
            currency = "₽"
        )


    )

    val totalAmount = remember { mock.sumOf { it.amount } }

    LazyList(
        topItem = {
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
        },
        itemsList = mock,
        itemTemplate = { item ->
            ListItem(

                modifier = Modifier.height(68.dp),
                content = {
                    Column(
                        horizontalAlignment = Alignment.Start
                    ) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
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

                    )
            }
        ) }
    )
}