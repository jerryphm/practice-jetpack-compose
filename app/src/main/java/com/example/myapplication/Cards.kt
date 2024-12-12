package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.Card

val listCard = listOf<Card>(
    Card(
        icon = R.drawable.ic_visa,
        cardType = "VISA",
        cardNumber = "4532 8493 9823 1324",
        cardName = "Personal",
        balance = 12_345.67,
        color = getGradient(Color(0xFF2193B0), Color(0xFF6DD5ED)) // Blue to light blue gradient
    ),
    Card(
        icon = R.drawable.ic_mastercard,
        cardType = "MasterCard",
        cardNumber = "5398 3748 9301 2345",
        cardName = "Travel",
        balance = 8_952.23,
        color = getGradient(Color(0xFFEE9CA7), Color(0xFFFFDDE1)) // Pink gradient
    ),
    Card(
        icon = R.drawable.ic_mastercard,
        cardType = "AMEX",
        cardNumber = "3714 4963 5398 431",
        cardName = "Business",
        balance = 25_000.00,
        color = getGradient(Color(0xFFDA22FF), Color(0xFF9733EE)) // Purple gradient
    ),
    Card(
        icon = R.drawable.ic_mastercard,
        cardType = "Discover",
        cardNumber = "6011 1111 1111 6611",
        cardName = "Savings",
        balance = 100_000.75,
        color = getGradient(Color(0xFFFF7E5F), Color(0xFFFFA07A)) // Orange to coral gradient
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview(showBackground = true)
@Composable
fun Cards(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(listCard.size) { index ->
            val paddingEnd = if (index == listCard.lastIndex) 16.dp else 0.dp
            Card(listCard[index], Modifier.padding(start = 16.dp, end = paddingEnd))
        }
    }
}

@Composable
fun Card(info: Card, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(info.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = info.icon),
                contentDescription = info.cardName,
                Modifier.height(36.dp)
            )
            Text(
                text = info.cardName,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.inverseSurface
            )
            Text(
                text = "$ ${info.balance.toString()}",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.inverseSurface
            )
            Text(
                text = info.cardNumber,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.inverseSurface
            )
        }
    }
}
