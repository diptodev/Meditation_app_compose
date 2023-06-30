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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.excitedbroltd.meditationappcompose.Feature
import com.excitedbroltd.meditationappcompose.R
import com.excitedbroltd.meditationappcompose.ui.drawCurvePath
import com.excitedbroltd.meditationappcompose.ui.theme.Beige1
import com.excitedbroltd.meditationappcompose.ui.theme.Beige2
import com.excitedbroltd.meditationappcompose.ui.theme.Beige3
import com.excitedbroltd.meditationappcompose.ui.theme.BlueViolet1
import com.excitedbroltd.meditationappcompose.ui.theme.BlueViolet2
import com.excitedbroltd.meditationappcompose.ui.theme.BlueViolet3
import com.excitedbroltd.meditationappcompose.ui.theme.ButtonBlue
import com.excitedbroltd.meditationappcompose.ui.theme.DarkerButtonBlue
import com.excitedbroltd.meditationappcompose.ui.theme.DeepBlue
import com.excitedbroltd.meditationappcompose.ui.theme.LightGreen1
import com.excitedbroltd.meditationappcompose.ui.theme.LightGreen2
import com.excitedbroltd.meditationappcompose.ui.theme.LightGreen3
import com.excitedbroltd.meditationappcompose.ui.theme.LightRed
import com.excitedbroltd.meditationappcompose.ui.theme.OrangeYellow1
import com.excitedbroltd.meditationappcompose.ui.theme.OrangeYellow2
import com.excitedbroltd.meditationappcompose.ui.theme.OrangeYellow3
import com.excitedbroltd.meditationappcompose.ui.theme.TextWhite

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreen() {
    val features = listOf(
        Feature(
            "Sleep Meditation",
            R.drawable.ic_headphone,
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ),
        Feature(
            "Tips for sleeping",
            R.drawable.ic_videocam,
            LightGreen1,
            LightGreen2,
            LightGreen3
        ),
        Feature(
            title = "Night island",
            R.drawable.ic_headphone,
            OrangeYellow1,
            OrangeYellow2,
            OrangeYellow3
        ),
        Feature(
            title = "Calming sounds",
            R.drawable.ic_headphone,
            Beige1,
            Beige2,
            Beige3
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
                .padding(start = 15.dp, end = 15.dp, top = 30.dp, bottom = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column() {
                Text(
                    text = "Good morning, Dipto",
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = TextWhite
                )
                Text(
                    text = "We wish you have a good day!",
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp,
                    color = TextWhite.copy(alpha = 0.7f)
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
                    .background(if (selectedChip == it) ButtonBlue else DarkerButtonBlue)
                    .padding(15.dp),

                ) {
                Text(text = "${chips[it]}", color = TextWhite)
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
            .background(LightRed)
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Daily Thought",
                    color = TextWhite,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(text = "Meditation 3-10 min", color = TextWhite.copy(alpha = 0.8f))
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Icon Play",
                    tint = Color.White,
                    modifier = Modifier.size(13.dp)
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
                val feature = features[it]
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .height(150.dp)
                        .background(feature.darkColor)
                        .drawBehind {
                            val height = size.height
                            val width = size.width
                            val point1 = Offset(0f, height * 0.15f)
                            val point2 = Offset(x = width * 0.2f, y = height * 0.6f)
                            val point3 = Offset(x = width * 0.4f, y = height * 0.1f)
                            val point4 = Offset(x = width * 0.7f, y = height * 0.7f)
                            val point5 = Offset(x = width, y = 0f)
                            val point6 = Offset(x = width, y = height)
                            val point7 = Offset(x = 0f, y = height)

                            val mpoint1 = Offset(0f, height * 0.25f)
                            val mpoint2 = Offset(x = width * 0.15f, y = height * 0.8f)
                            val mpoint3 = Offset(x = width * 0.4f, y = height * 0.4f)
                            val mpoint4 = Offset(x = width * 0.8f, y = height * 0.8f)
                            val mpoint5 = Offset(x = width, y = height * 0.2f)
                            val mpoint6 = Offset(x = width, y = height)
                            val mpoint7 = Offset(x = 0f, y = height)

                            val path = Path()
                                .apply {
                                    moveTo(point1.x, point2.y)
                                    drawCurvePath(point1, point2)
                                    drawCurvePath(point2, point3)
                                    drawCurvePath(point3, point4)
                                    drawCurvePath(point4, point5)
                                }
                            path.lineTo(point5.x, point5.y)
                            path.lineTo(point6.x, point6.y)
                            path.lineTo(point7.x, point7.y)
                            drawPath(path = path, color = feature.mediumColor)

                            val mpath = Path()
                                .apply {
                                    moveTo(mpoint1.x, mpoint2.y)
                                    drawCurvePath(mpoint1, mpoint2)
                                    drawCurvePath(mpoint2, mpoint3)
                                    drawCurvePath(mpoint3, mpoint4)
                                    drawCurvePath(mpoint4, mpoint5)
                                }
                            mpath.lineTo(mpoint5.x, mpoint5.y)
                            mpath.lineTo(mpoint6.x, mpoint6.y)
                            mpath.lineTo(mpoint7.x, mpoint7.y)
                            drawPath(path = mpath, color = feature.lightColor)

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
                            text = feature.title, color = TextWhite,
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
                                    .clip(RoundedCornerShape(15.dp))
                                    .background(ButtonBlue)
                                    .padding(10.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Start", color = TextWhite)
                            }
                        }
                    }

                }
            }
        }
    }
}
