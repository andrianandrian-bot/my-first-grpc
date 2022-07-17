package com.example.myspring.entity

import com.example.myspring.dto.ExerciseVideoDTO
import javax.persistence.*

@Entity
@Table(name = "exercise_video")
class ExerciseVideoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "duration_minutes")
    var durationMinutes: Int?,

    @Column(name = "name")
    var name: String?,

    @Column(name = "category_name")
    var categoryName: String?,

    @Column(name = "video_path")
    var videoPath: String?,

    @Column(name = "training_id")
    var trainingID: Int?,

    @ManyToOne
    @JoinColumn(name = "training_id", updatable = false, insertable = false)
    val training: TrainingEntity?
) {
    fun toDTO() = ExerciseVideoDTO(
        id, durationMinutes, name, categoryName, videoPath, trainingID
    )
}