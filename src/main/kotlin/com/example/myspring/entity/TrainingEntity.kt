package com.example.myspring.entity

import com.example.myspring.dto.TrainingDTO
import com.example.myspring.dto.TrainingTypeDTO
import java.sql.Timestamp
import javax.persistence.*


@Entity
@Table(name = "trainings")
class TrainingEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "creation_date", updatable = false, insertable = false)
    var creationDate: String?,

    @Column(name = "training_type")
    val trainingType: Int,

    @Column(name = "exercise_count")
    val exerciseCount: Int,

    @Column(name = "duration_minutes")
    val durationMinutes: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "difficult_level")
    val difficultLevel: DifficultLevel?,

    @Column(name = "name")
    val name: String,

    @Column(name = "preview_path")
    val previewPath: String,

    @OneToMany(mappedBy = "training")
    val exercises: List<ExerciseVideoEntity>? = emptyList()

) {
    enum class DifficultLevel {
        easy,
        hard,
        medium,
    }

    fun toDTO(): TrainingDTO {
        return TrainingDTO(
            id = this.id,
            creationDate = this.creationDate,
            trainingType = this.trainingType,
            exerciseCount = this.exerciseCount,
            durationMinutes = this.durationMinutes,
            difficultLevel = this.difficultLevel,
            name = this.name,
            previewPath = this.previewPath,
            exercises = this.exercises?.map { it.toDTO() }
//            type = this.type.toDTO()
        )
    }

    fun TrainingTypeEntity.toDTO(): TrainingTypeDTO {
        return TrainingTypeDTO(
            id, name
        )
    }
}
