package com.example.comp319assignment3

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SelectedFitnessProgramPage(navController: NavController, fitnessViewModel: FitnessDetailViewModel) {

    val selected = fitnessViewModel.selectedDay.value

    if (selected != null) {

        var notes by remember { mutableStateOf(selected.notes) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }

            LaunchedEffect(selected) {
                fitnessViewModel.getDayNotes(selected).collect {
                    notes = it ?: ""
                }
            }

            Image(
                painter = painterResource(id = selected.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(12.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )


            Text(text = stringResource(selected.title), style = TextStyle(fontSize = 28.sp))
            Text(text = "Equipment:" + stringResource(selected.equipment), style = TextStyle(fontSize = 28.sp))

            Divider(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            )

            Log.i("Notes", notes)
            TextField(
                value = notes,
                onValueChange = {
                    fitnessViewModel.saveDayNotes(selected, it)
                    notes = it
                },
                label = { Text("Notes") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}