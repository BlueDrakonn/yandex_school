package com.example.bankapp.ui.screen

import ListItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.bankapp.R
import com.example.bankapp.ui.common.LazyList
import com.example.bankapp.ui.common.LeadIcon
import com.example.bankapp.ui.common.PriceDisplay

import com.example.bankapp.ui.model.AccountUi

@Composable
fun AccountsScreen() {

    val mock = listOf(
        AccountUi(
            id = 1,
            amount = -601200.0,
            currency = "₽",
        )
    )


    LazyList(
        itemsList = mock,
        lastItemDivider = {},
        itemTemplate = { item ->
            ListItem(
                modifier = Modifier.background(MaterialTheme.colorScheme.secondary),
                lead = {

                    LeadIcon(
                        backGroundColor = MaterialTheme.colorScheme.background,
                        label = "💰"
                    )
                },
                content = {
                    Text(stringResource(R.string.balance))
                },
                trailingContent = {
                    PriceDisplay(
                        amount = item.amount,
                        currencySymbol = item.currency,
                    )
                },
                trailIcon = {
                    Icon(painter = painterResource(R.drawable.drillin),
                        contentDescription = null,
                    )
                },
                onTrailClick = { }
            )
            HorizontalDivider( color = MaterialTheme.colorScheme.outlineVariant)

            ListItem(
                modifier = Modifier.background(MaterialTheme.colorScheme.secondary),
                content = {
                    Text(
                        text = stringResource(R.string.currency),
                    )
                },
                trailingContent = {
                    Text(
                        text = item.currency,
                    )
                },
                trailIcon = {
                    Icon(painter = painterResource(R.drawable.drillin),
                        contentDescription = null,
                    )
                },
                onTrailClick = {  }
            )

        }
    )

}