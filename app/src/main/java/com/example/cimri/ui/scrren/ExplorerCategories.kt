package com.example.cimri.ui.scrren


import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cimri.R

@Composable
fun ExploreCategoriesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Başlık
        Text(
            text = "Kategorileri Keşfet",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Kategori kartları
        CategoryList()
    }
}

@Composable
fun CategoryList() {
    val categories = listOf(
        Category("Elektronik,Cep Telefonu", R.drawable.phone),
        Category("Ev, Yaşam,Ofis", R.drawable.office),
        Category("Anne, Bebek, Oyuncak", R.drawable.baby),
        Category("Saat,Moda, Takı,Ayakkabı", R.drawable.jacket),

    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()), // Yatay kaydırılabilir yapı
        horizontalArrangement = Arrangement.spacedBy(8.dp) // Kartlar arası boşluk
    ) {
        categories.forEach { category ->
            CategoryCard(category)
        }
    }
}

@Composable
fun CategoryCard(category: Category) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(130.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center // İçeriği dikey olarak ortalar
        ) {
            // Kategori resmi
            Image(
                painter = painterResource(id = category.icon),
                contentDescription = category.name,
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.height(8.dp)) // Resim ile yazı arasında boşluk

            // Kategori adı
            Text(
                text = category.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally) // Yazıyı yatay olarak ortalar
            )
        }
    }
}


// Kategori verisi
data class Category(val name: String, val icon: Int)
