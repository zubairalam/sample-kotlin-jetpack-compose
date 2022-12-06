package com.devhustlers.eduone.ui.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.devhustlers.eduone.ProblemDetailActivity
import com.devhustlers.eduone.ProblemList
import com.devhustlers.eduone.ProblemSolutionActivity

@Composable
fun Navigation () {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ProblemListActivity") {

        composable(
            route = "ProblemListActivity"
        ) {
            ProblemList(navController)
        }

        composable(
            route = "ProblemDetailActivity/{problemID}",
            arguments = listOf(
                navArgument("problemID") {
                    type = NavType.StringType
                }
            )
        ) {
            ProblemDetailActivity(
                navController,
                it.arguments?.getString("problemID")
            )
        }

        composable(
            route = "ProblemSolutionActivity/{problemID}",
            arguments = listOf(
                navArgument("problemID") {
                    type = NavType.StringType
                }
            )
        ) {
            ProblemSolutionActivity(
                navController,
                it.arguments?.getString("problemID")
            )
        }

    }

}