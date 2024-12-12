package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Doorbell
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.data.BottomNavigationItems

val listIcon = listOf<BottomNavigationItems>(
    BottomNavigationItems(title = "Home", icon = Icons.Rounded.Home),
    BottomNavigationItems(title = "Wallet", icon = Icons.Rounded.Wallet),
    BottomNavigationItems(title = "Notification", icon = Icons.Rounded.Doorbell),
    BottomNavigationItems(title = "Account", icon = Icons.Rounded.AccountCircle)
)

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.primary)
        ) {
            listIcon.forEachIndexed() { index, item ->
                val selected = index == 0

                NavigationBarItem(
                    selected = selected,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.inversePrimary
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                )
                    
            }
        }
    }
}