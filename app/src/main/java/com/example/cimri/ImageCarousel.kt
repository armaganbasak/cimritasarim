package com.example.cimri

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.room.util.copy
import androidx.wear.compose.material.ContentAlpha
import com.example.cimri.R

@Composable
fun ImageCarousel() {
    val imageResources = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7

    )

    val pagerState = rememberPagerState(0) { imageResources.size }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Kaydırılabilir Resim
        HorizontalPager (
            beyondViewportPageCount = imageResources.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) { page ->
            // Resim
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Image(
                    painter = painterResource(id = imageResources[page]),
                    contentDescription = "Image",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        //(Indicators)
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            imageResources.forEachIndexed { index, _ ->
                // Aktif olan nokta için farklı renk, diğerleri için gri
                val indicatorColor = if (pagerState.currentPage == index) Color.Blue else Color.Gray
                Spacer(modifier = Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .padding(2.dp)
                        .background(indicatorColor, shape = CircleShape)
                )
            }
        }
    }
}