package com.devhustlers.eduone

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.devhustlers.eduone.ui.theme.nunitoBold
import com.devhustlers.eduone.ui.theme.nunitoLight
import com.devhustlers.eduone.ui.utils.PROBLEM_LIST_ITEMS
import com.devhustlers.eduone.ui.utils.ProblemSummary

@Composable
fun ProblemDetailActivity(navController: NavController, problemID: String?) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        for (problem: ProblemSummary in PROBLEM_LIST_ITEMS) {
            if (problem.id == problemID) {
                Text(
                    text = problem.title,
                    fontFamily = nunitoBold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start
                )
                
                Spacer(modifier = Modifier.padding(vertical = 10.dp))

                Text(
                    text = problem.detail,
                    fontFamily = nunitoLight,
                    fontSize = 18.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start
                )

                Button(onClick = { navController.navigate("ProblemSolutionActivity/${problem.id}") }) {
                    Text(text = "View Solutions")
                }

            }
        }



    }
}