package com.example.bankapp.ui.screen

import ListItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.bankapp.ui.common.LeadIcon
import com.example.bankapp.ui.model.Category


@Composable
fun CategoriesScreen() {
    val mock = listOf(
        Category(
            id = 1,
            title = "путешествие",
            icon = "☎",
        ),
        Category(
            id = 2,
            title = "Одежда",
            icon = "☕",
        ),
        Category(
            id = 3,
            title = "аренда квартиры",
            icon = "АК",
        ),
        Category(
            id = 4,
            title = "Кофе",
            icon = "КФ",
        ),


    )

    var searchQuery by remember { mutableStateOf("") }

    Column {
        Row {
            SearchInput(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearchClick = {  }
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
                    lead = { LeadIcon(label = item.icon) },
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
                    }
                )
            }
        }
    }
}


@Composable
fun SearchInput(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.surfaceContainer)
            .fillMaxWidth()
            .height(56.dp),
        shape = RectangleShape,
        placeholder = {
            Text(
                "Найти статью",
                color = MaterialTheme.colorScheme.onSecondary,
                style = MaterialTheme.typography.bodyLarge) },
        trailingIcon = {
            IconButton(onClick = onSearchClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Поиск"
                )
            }
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.onSecondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.surfaceContainer,
            focusedBorderColor = MaterialTheme.colorScheme.surfaceContainer
        )
    )
}