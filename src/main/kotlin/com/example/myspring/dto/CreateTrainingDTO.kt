package com.example.myspring.dto

import com.example.myspring.entity.TrainingEntity
import java.sql.Timestamp

data class CreateTrainingDTO(
    val trainingType: Int,
    val exerciseCount: Int,
    val durationMinutes: Int,
    var difficultLevel: TrainingEntity.DifficultLevel,
    val name: String,
    val previewPath: String,
) {
    fun toEntity(): TrainingEntity {
        return TrainingEntity(
            id = 0,
            creationDate = null,
            trainingType = this.trainingType,
            exerciseCount = this.exerciseCount,
            durationMinutes = this.durationMinutes,
            difficultLevel = this.difficultLevel,
            name = this.name,
            previewPath = this.previewPath,
//            type = TrainingType(id = this.type.id, name = this.type.name)
        )
    }


}
