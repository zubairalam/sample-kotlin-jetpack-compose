package com.devhustlers.eduone

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.devhustlers.eduone.ui.theme.Black
import com.devhustlers.eduone.ui.theme.nunitoBold
import com.devhustlers.eduone.ui.theme.nunitoLight
import com.devhustlers.eduone.ui.theme.nunitoMedium
import com.devhustlers.eduone.ui.utils.PROBLEM_LIST_ITEMS
import com.devhustlers.eduone.ui.utils.ProblemSummary

@Composable
fun ProblemList(navController: NavController) {
    val problemListItems = PROBLEM_LIST_ITEMS
    LazyColumn(
        Modifier.padding(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        items(problemListItems.size) {
            ProblemListItem(problemSummary = problemListItems[it], navController)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProblemListItem(problemSummary: ProblemSummary, navController: NavController) {
    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxSize(),
        backgroundColor = problemSummary.backgroundColor,
        onClick = {navController.navigate("ProblemDetailActivity/${problemSummary.id}")}
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(20.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Chip(
                    onClick = { /*TODO*/ },
                    colors = ChipDefaults.chipColors(
                        contentColor = Black,
                        backgroundColor = problemSummary.timeBackgroundColor
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = problemSummary.level, fontFamily = nunitoMedium)
                }
                Chip(
                    onClick = { /*TODO*/ },
                    colors = ChipDefaults.chipColors(
                        contentColor = Black,
                        backgroundColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = problemSummary.topic, fontFamily = nunitoMedium)
                }
            }

            Text(
                text = problemSummary.title,
                fontFamily = nunitoBold,
                fontSize = 18.sp,
                color = problemSummary.contentColor,
                textAlign = TextAlign.Start
            )

            Text(
                text = problemSummary.description,
                fontFamily = nunitoLight,
                fontSize = 16.sp,
                color = problemSummary.contentColor,
                textAlign = TextAlign.Start
            )
        }
    }
}