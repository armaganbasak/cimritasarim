package com.example.cimri.ui.scrren

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cimri.ImageCarousel
import com.example.cimri.ui.screen.TopCards
import com.example.cimri.ui.scrren.ExploreCategoriesScreen
import com.example.cimri.ui.scrren.PopularProducts

@Composable
fun HomeScreen(navController: NavController) {
    var selectedIndex by remember  { mutableStateOf(0) }

    Column (modifier = Modifier.fillMaxSize()
        .background(color = Color.White)
        .verticalScroll(rememberScrollState())

    ) {
        // Üstteki kartlar
        TopCards()
        ImageCarousel()
        ExploreCategoriesScreen()
        PopularProducts()

        Spacer(modifier = Modifier.weight(1f))



    }
}


