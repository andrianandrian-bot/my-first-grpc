package com.example.myspring.service.first_service

import com.example.myspring.entity.CountryEntity
import com.example.myspring.dto.CreateTrainingDTO
import com.example.myspring.dto.ExerciseVideoDTO
import com.example.myspring.dto.TrainingDTO
import com.example.myspring.entity.TrainingEntity

interface MyService {
    fun fetchCountries(): List<CountryEntity>
    fun fetchTrainings(page: Int): List<TrainingDTO>
    fun findByID(id: Int): TrainingDTO
    fun findByName(prefix: String): List<TrainingDTO>
    fun creatTraining(dto: CreateTrainingDTO): TrainingDTO
    fun findExerciseByID(id: Int): ExerciseVideoDTO
}