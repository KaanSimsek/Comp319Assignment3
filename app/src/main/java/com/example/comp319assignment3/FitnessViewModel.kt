package com.example.comp319assignment3

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FitnessDetailViewModel {

    private val _selectedFitnessDay = MutableStateFlow<FitnessProgram?>(null)
    val selectedDay: StateFlow<FitnessProgram?> = _selectedFitnessDay.asStateFlow()

    private val fitnessNotesMap = mutableMapOf<FitnessProgram, MutableStateFlow<String?>>()

    fun getDayNotes(day: FitnessProgram): StateFlow<String?> {
        return fitnessNotesMap.getOrPut(day) {
            MutableStateFlow(null)
        }
    }

    fun saveDayNotes(day: FitnessProgram, notes: String) {
        fitnessNotesMap[day]?.value = notes
    }

    fun setSelectedDay(day: FitnessProgram) {
        _selectedFitnessDay.value = day
    }
}