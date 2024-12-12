package com.example.myapplication

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBalance
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CreditCard
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.TrendingUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Finance

val listFinance = listOf<Finance>(
    Finance(
        icon = Icons.Rounded.AttachMoney,
        name = "Investments",
        background = Color(0xFF388E3C) // Forest Green
    ),
    Finance(
        icon = Icons.Rounded.TrendingUp,
        name = "Growth",
        background = Color(0xFF1976D2) // Royal Blue
    ),
    Finance(
        icon = Icons.Rounded.ShoppingCart,
        name = "Expenses",
        background = Color(0xFFC62828) // Crimson Red
    ),
    Finance(
        icon = Icons.Rounded.AccountBalance,
        name = "Savings",
        background = Color(0xFFF9A825) // Amber Gold
    ),
    Finance(
        icon = Icons.Rounded.CreditCard,
        name = "Payments",
        background = Color(0xFF8E24AA) // Orchid Purple
    )
)

@Preview(showBackground = true)
@Composable
fun Finance(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Finance",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            modifier = Modifier
        ) {
            items(listFinance.size) { index ->
                Spacer(modifier = Modifier.width(16.dp))
                FinanceItem(listFinance[index])
                if (index == listFinance.lastIndex) {
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }
}

@Composable
fun FinanceItem(info: Finance, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(lerp(info.background, Color.White, 0.3f))
            .padding(horizontal = 14.dp, vertical = 12.dp)
            .widthIn(min = 80.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(100))
                .background(info.background)
                .padding(6.dp)
        ) {
            Icon(imageVector = info.icon, contentDescription = info.name, tint = Color.White)
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = info.name, style = MaterialTheme.typography.bodyMedium, color = Color.White)
    }
}