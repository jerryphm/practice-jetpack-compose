package com.example.myapplication

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Currency

val listExchangeRate = listOf<Currency>(
    Currency(name = "USD", symbol = "$", buy = 23.35, sell = 23.20),
    Currency(name = "EUR", symbol = "€", buy = 25.50, sell = 25.75),
    Currency(name = "GBP", symbol = "£", buy = 28.20, sell = 27.50),
    Currency(name = "JPY", symbol = "¥", buy = 0.17, sell = 0.18),
    Currency(name = "AUD", symbol = "A$", buy = 15.60, sell = 12.85),
    Currency(name = "CNY", symbol = "¥", buy = 3.60, sell = 3.65),
    Currency(name = "CAD", symbol = "C$", buy = 17.80, sell = 18.05),
    Currency(name = "CHF", symbol = "Fr.", buy = 25.20, sell = 24.45),
    Currency(name = "KRW", symbol = "₩", buy = 0.019, sell = 0.020),
    Currency(name = "INR", symbol = "₹", buy = 0.29, sell = 0.31),
    Currency(name = "NZD", symbol = "NZ$", buy = 14.80, sell = 15.10),
    Currency(name = "SGD", symbol = "S$", buy = 17.10, sell = 17.25),
    Currency(name = "RUB", symbol = "₽", buy = 75.00, sell = 76.00),
    Currency(name = "MXN", symbol = "$", buy = 0.45, sell = 0.43),
    Currency(name = "BRL", symbol = "R$", buy = 4.60, sell = 4.70),
    Currency(name = "ZAR", symbol = "R", buy = 0.60, sell = 0.4),
    Currency(name = "SEK", symbol = "kr", buy = 2.50, sell = 2.60),
    Currency(name = "NOK", symbol = "kr", buy = 2.40, sell = 2.50),
    Currency(name = "DKK", symbol = "kr", buy = 3.00, sell = 3.10),
    Currency(name = "PLN", symbol = "zł", buy = 5.20, sell = 5.30),
    Currency(name = "TRY", symbol = "₺", buy = 0.10, sell = 0.12),
    Currency(name = "HUF", symbol = "Ft", buy = 70.00, sell = 72.00),
    Currency(name = "AED", symbol = "د.إ", buy = 6.80, sell = 7.00),
    Currency(name = "SAR", symbol = "ر.س", buy = 6.60, sell = 6.80),
    Currency(name = "KES", symbol = "KSh", buy = 100.00, sell = 105.00),
    Currency(name = "EGP", symbol = "ج.م", buy = 0.30, sell = 0.32),
    Currency(name = "IDR", symbol = "Rp", buy = 0.15, sell = 0.17),
    Currency(name = "THB", symbol = "฿", buy = 0.75, sell = 0.80),
    Currency(name = "PHP", symbol = "₱", buy = 1.10, sell = 1.20),
    Currency(name = "VND", symbol = "₫", buy = 0.00095, sell = 0.001),
    Currency(name = "MYR", symbol = "RM", buy = 5.00, sell = 5.10),
    Currency(name = "TWD", symbol = "NT$", buy = 0.75, sell = 0.80),
    Currency(name = "KWD", symbol = "د.ك", buy = 0.30, sell = 0.32),
    Currency(name = "OMR", symbol = "ر.ع.", buy = 0.38, sell = 0.40),
    Currency(name = "BHD", symbol = "ب.د", buy = 0.40, sell = 0.42),
    Currency(name = "QAR", symbol = "ر.ق", buy = 6.60, sell = 6.80),
    Currency(name = "JOD", symbol = "د.ا", buy = 0.70, sell = 0.75),
    Currency(name = "LKR", symbol = "Rs", buy = 120.00, sell = 125.00),
    Currency(name = "BGN", symbol = "лв", buy = 1.90, sell = 2.00),
    Currency(name = "RON", symbol = "lei", buy = 5.20, sell = 5.40),
    Currency(name = "CLP", symbol = "$", buy = 750.00, sell = 800.00),
    Currency(name = "COP", symbol = "$", buy = 4000.00, sell = 4200.00)
)

@Preview
@Composable
fun ExchangeRate(modifier: Modifier = Modifier) {
    var isVisible by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier.animateContentSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 12.dp)
                .animateContentSize()
                .fillMaxWidth()
        ) {
            Text(text = "Exchange Rate", style = MaterialTheme.typography.titleLarge)
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .background(MaterialTheme.colorScheme.onSecondary)
                    .clickable {
                        isVisible = !isVisible
                    }
            ) {
                Icon(
                    imageVector = if (isVisible) Icons.Rounded.KeyboardArrowUp else Icons.Rounded.KeyboardArrowDown,
                    contentDescription = "Toggle Exchange Rate Section"
                )
            }
        }

        if (isVisible) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp, horizontal = 16.dp)
                    ) {
                        Text(
                            text = "Currency",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color(0xFF999999),
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 4.dp)
                        )
                        Text(
                            text = "Buy",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color(0xFF999999),
                            modifier = Modifier
                                .weight(0.4f)
                        )
                        Text(
                            text = "Sell",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color(0xFF999999),
                            modifier = Modifier
                                .weight(0.4f)
                        )
                    }

                    LazyColumn {
                        items(listExchangeRate.size) { index ->
                            val currency = listExchangeRate[index]
                            val isUp = currency.buy <= currency.sell

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 12.dp, horizontal = 16.dp)
                            ) {
                                Text(
                                    text = "${currency.name} (${currency.symbol})",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = if (isUp) Color.Green else Color.Red,
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 8.dp)
                                )
                                Text(
                                    text = currency.buy.toString(),
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier
                                        .weight(0.4f)
                                )
                                Text(
                                    text = currency.sell.toString(),
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier
                                        .weight(0.4f)
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}
