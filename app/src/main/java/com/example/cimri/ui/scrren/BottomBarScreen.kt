package com.example.cimri.ui.scrren

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cimri.R

@Composable
fun BottomBarSayfa() {

    val secilenItem = remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(90.dp),
                containerColor = Color.White
            ) {
                NavigationBarItem(
                    selected = secilenItem.value == 0,
                    onClick = { secilenItem.value = 0 },
                    label = {
                        Text(
                            text = "Anasayfa",
                            color = if (secilenItem.value == 0) Color(10, 109, 185, 255) else Color.Gray
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ev),
                            contentDescription = " ",
                            tint = if (secilenItem.value == 0) Color(10, 109, 185, 255) else Color.Gray
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.White
                    )
                )
                NavigationBarItem(
                    selected = secilenItem.value == 1,
                    onClick = { secilenItem.value = 1 },
                    label = {
                        Text(
                            text = "Kategoriler",
                            color = if (secilenItem.value == 1) Color(10, 109, 185, 255) else Color.Gray
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.category_search),
                            contentDescription = " ",
                            tint = if (secilenItem.value == 1) Color(10, 109, 185, 255) else Color.Gray
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.White
                    )

                )

                NavigationBarItem(
                    selected = secilenItem.value == 2,
                    onClick = { secilenItem.value = 2 },
                    label = {
                        Text(
                            text = "Hesabım",
                            color = if (secilenItem.value == 2) Color(10, 109, 185, 255) else Color.Gray
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.person),
                            contentDescription = " ",
                            tint = if (secilenItem.value == 2) Color(10, 109, 185, 255) else Color.Gray
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.White
                    )
                )
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            if (secilenItem.value == 0) {
                SayfaGecisleri(selectedScreen = "anasayfa")
            }
        }
    }
}
