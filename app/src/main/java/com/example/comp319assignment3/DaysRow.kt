package com.example.comp319assignment3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DaysRow(navController: NavController, fitnessProgram: FitnessProgram, fitnessDetailViewModel: FitnessDetailViewModel, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier
            .padding(5.dp)
            .height(80.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(4.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(fitnessProgram.title),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                        .padding(start = 12.dp),
                    style = TextStyle(fontSize = 25.sp)
                )
                DayDetailButton(
                    onClick = {
                        fitnessDetailViewModel.setSelectedDay(fitnessProgram)
                        navigateToDetailPage(navController) },
                )
            }
        }
    }

}


fun navigateToDetailPage(navController: NavController) {
    val route = "DayDetail"
    navController.navigate(route)
}

@Composable
fun DayDetailButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.KeyboardArrowRight,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}