package com.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ChoosingCards(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }
    var selectedCard by remember { mutableStateOf(-1) }

    // Step 1: Create an array with photo file names and IDs
    val photos = remember {
        listOf(
            "photo1" to R.drawable.dy1,  // Replace with your actual drawable IDs
            "photo2" to R.drawable.dy2,
            "photo3" to R.drawable.dy3,
            "photo4" to R.drawable.dy4,
            "photo5" to R.drawable.dy5,
            "photo6" to R.drawable.dy6,
            "photo7" to R.drawable.hc1,
            "photo8" to R.drawable.hc2,
            "photo9" to R.drawable.hc3
        ).shuffled()  // Step 2: Shuffle to randomize the order
    }

    // Track which cards have been revealed
    val revealedCards = remember { mutableStateListOf<Boolean>().apply { repeat(photos.size) { add(false) } } }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#f2f1f6")))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "請抽卡", fontSize = 40.sp, fontWeight = FontWeight.SemiBold)

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(top = 16.dp)
        ) {
            items(photos.size) { index ->
                val (fileName, drawableId) = photos[index]

                Box(
                    modifier = Modifier
                        .aspectRatio(3 / 4f)
                        .padding(8.dp)
                        .background(Color.Gray)
                        .clickable {
                            if (!revealedCards[index]) {
                                revealedCards[index] = true
                            }
                            selectedCard = index
                            showDialog = true
                        }
                ) {
                    if (revealedCards[index]) {
                        Image(
                            painter = painterResource(id = drawableId),
                            contentDescription = fileName,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Black)
                        )
                    }
                }
            }
        }
    }

    if (showDialog) {
        val (selectedFileName, selectedDrawableId) = photos[selectedCard]

        AlertDialog(
            onDismissRequest = { showDialog = false },
            buttons = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color(0xFFD5BFA0))
                        .padding(all = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = selectedDrawableId),
                        contentDescription = selectedFileName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(3 / 4f)
                            .padding(bottom = 16.dp)
                    )
                    Text(
                        text = "是否確定要抽取這張卡片？",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(bottom = 16.dp),
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = {
                                showDialog = false
                                navController.navigate("chatting")
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE9E8E5),
                                contentColor = Color.Black
                            ),
                        ) {
                            Text("是", fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(
                            onClick = {
                                // Reset the card to black if "否" is chosen
                                revealedCards[selectedCard] = false
                                showDialog = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE9E8E5),
                                contentColor = Color.Black
                            ),
                        ) {
                            Text("否", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        )
    }
}