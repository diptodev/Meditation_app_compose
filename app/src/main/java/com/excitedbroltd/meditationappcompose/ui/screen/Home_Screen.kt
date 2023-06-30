package com.excitedbroltd.meditationappcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.excitedbroltd.meditationappcompose.Feature
import com.excitedbroltd.meditationappcompose.R
import com.excitedbroltd.meditationappcompose.ui.theme.DeepBlue

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreen() {
    val features = listOf(
        Feature(
            "Sleep Meditation",
            R.drawable.ic_headphone,
            Color.LightGray,
            Color.Gray,
            Color.Gray
        ),
        Feature(
            "Tips for sleeping",
            R.drawable.ic_videocam,
            Color.LightGray,
            Color.Gray,
            Color.Gray
        ),
        Feature(
            "Night island",
            R.drawable.ic_headphone,
            Color.LightGray,
            Color.Gray,
            Color.Gray
        ),
        Feature(
            "Calming sounds",
            R.drawable.ic_headphone,
            Color.LightGray,
            Color.Gray,
            Color.Gray
        )
    )
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            Headings()
            ChipSection()
            CurrentMeditation()
            Features(features = features)
        }
    }
}

@Composable
fun Headings() {
    Box() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(
                    text = "Good morning, Dipto",
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.White
                )
                Text(
                    text = "We wish you have a good day!",
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp,
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Icon",
                tint = Color.White,
                modifier = Modifier.size(25.dp)
            )
        }

    }
}

@Composable
fun ChipSection() {
    val chips = listOf("Potato", "Tomato", "Sweet Sleep", "Insomnia")
    var selectedChip by remember {
        mutableStateOf(0)
    }
    LazyRow(userScrollEnabled = true) {
        items(count = chips.size) {
            Box(
                modifier = Modifier
                    .padding(
                        start = 15.dp, top = 15.dp, bottom = 15.dp
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        selectedChip = it
                    }
                    .background(if (selectedChip == it) Color.Green else Color.LightGray)
                    .padding(15.dp),

                ) {
                Text(text = "${chips[it]}")
            }
        }
    }
}

@Composable
fun CurrentMeditation() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Blue)
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column() {
                Text(
                    text = "Daily Thought",
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Meditation 3-10 min", color = Color.White.copy(alpha = 0.8f))
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Green)
                    .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Icon Play",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun Features(features: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 15.dp, end = 15.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(count = features.size) {
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .height(150.dp)
                        .drawBehind {
                            drawRect(color = Color.Cyan)
                        }

                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxHeight()
                    ) {
                        val feature = features[it]
                        Text(
                            text = feature.title, color = Color.White,
                            modifier = Modifier.padding(1.dp),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            Icon(
                                painter = painterResource(id = feature.iconId),
                                contentDescription = feature.title,
                                tint = Color.White
                            )
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(DeepBlue)
                                    .padding(10.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Start", color = Color.White)
                            }
                        }
                    }

                }
            }
        }
    }
}
