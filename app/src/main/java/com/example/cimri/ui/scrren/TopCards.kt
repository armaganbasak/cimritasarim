package com.example.cimri.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cimri.R

@Composable
fun TopCards() {
    // Seçilen kartı kontrol eden state
    val selectedCard = remember { mutableStateOf("none") }
    // Arama çubuğu için metin
    val searchQuery = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp) // Kartlar arasındaki boşluk
    ) {
        // Kartlar
        Row(
            modifier = Modifier
                .height(80.dp)

                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Cimri Kartı
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable { selectedCard.value = "cimri" }
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cimri_logo),
                    contentDescription = "Cimri Image",
                    modifier = Modifier.size(80.dp)
                )
            }

            // Cimri Market Kartı
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable { selectedCard.value = "market" }
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cimri_markette),
                    contentDescription = "Cimri Market Image",
                    modifier = Modifier.size(90.dp)
                )
            }

            // Cimri Finans Kartı
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable { selectedCard.value = "finans" }
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cimri_finans),
                    contentDescription = "Cimri Finans Image",
                    modifier = Modifier.size(90.dp)
                )
            }
        }

        // Arama çubuğu
        SearchBar(
            searchQuery = searchQuery.value,
            onSearchChange = { searchQuery.value = it }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(searchQuery: String, onSearchChange: (String) -> Unit) {
    // Search bar için TextField bileşeni
    OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp, vertical = 2.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "Search Icon"
            )
        },
        placeholder = { Text(text = "Ürün, marka veya kategori ara") },
        shape = RoundedCornerShape(4.dp),
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Blue,
            cursorColor = Color.Blue,
            focusedLabelColor = Color.Blue,
            unfocusedLabelColor = Color.Gray
        )
    )
}
