package com.example.cimri.ui.scrren

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cimri.R

@Composable
fun PopularProducts() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Popüler Ürünler",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        PopularProductList()
    }
}

@Composable
fun PopularProductList() {
    val products = listOf(
        Product("Apple Iphone 13 128GB", R.drawable.iphone, "34000 TL", seller = "Amazon"),
        Product("Xiaomi Redmi Note 13 Pro", R.drawable.xiaomi, "10133 TL", seller = "PttAVM"),
        Product("Apple Iphone 16 Pro Max 256GB", R.drawable.iphone2, "84999 TL", seller = "PttAVM"),
        Product("Xiaomi Redmi Note 13 Pro 512GB", R.drawable.xiaomi2, "12691 TL", seller ="PttAVM" ),
        Product("Apple Iphone 14 128GB", R.drawable.iphone3, "42399 TL", seller = "Teknosa"),
    )

    Row(
        modifier = Modifier.fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        products.forEach { product ->
            ProductCard(product)
        }
    }

}

@Composable
fun ProductCard(product: Product) {
    Box(
        modifier = Modifier.width(150.dp)
            .height(200.dp)
    ) {
        Card(
            modifier = Modifier.width(150.dp)
                .height(200.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = product.image),
                    contentDescription = product.name,
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = product.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(3.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = product.seller,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray
                    )
                }

                Text(
                    text = product.price,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.notifications),
            contentDescription = "Notif",
            modifier = Modifier.align(Alignment.TopEnd)
                .padding(8.dp)
                .size(24.dp)
        )
    }

}


data class Product(val name: String, val image : Int, val price: String, val seller: String )