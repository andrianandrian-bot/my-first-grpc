package com.example.myspring.repository

import com.example.myspring.entity.ExerciseVideoEntity
import org.springframework.data.repository.CrudRepository

interface ExerciseRepository: CrudRepository<ExerciseVideoEntity, Int> {
}