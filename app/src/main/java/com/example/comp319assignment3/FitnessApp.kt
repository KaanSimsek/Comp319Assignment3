package com.example.comp319assignment3

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessApp() {
    val navController = rememberNavController()
    val fitnessDetailViewModel = remember { FitnessDetailViewModel() }
    NavHost(
        navController = navController,
        startDestination = "Days"
    ) {
        composable("Days") { FitnessDays(navController, fitnessDetailViewModel) }
        composable("DayDetail") { SelectedFitnessProgramPage(navController, fitnessDetailViewModel) }
    }
}