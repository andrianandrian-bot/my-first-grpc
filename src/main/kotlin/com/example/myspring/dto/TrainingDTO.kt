package com.example.myspring.dto

import com.example.myspring.entity.ExerciseVideoEntity
import com.example.myspring.entity.TrainingEntity

data class TrainingDTO(
    val id: Int? = null,
    var creationDate: String?,
    val trainingType: Int,
    val exerciseCount: Int,
    val durationMinutes: Int,
    val difficultLevel: TrainingEntity.DifficultLevel?,
    val name: String,
    val previewPath: String,
    val exercises: List<ExerciseVideoDTO>? = emptyList(),
//    val type: TrainingTypeDTO
)
