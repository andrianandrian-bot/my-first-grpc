package com.example.myspring.dto


data class ExerciseVideoDTO(
    val id: Int,
    var durationMinutes: Int?,
    var name: String?,
    var categoryName: String?,
    var videoPath: String?,
    var trainingID: Int?,
)
