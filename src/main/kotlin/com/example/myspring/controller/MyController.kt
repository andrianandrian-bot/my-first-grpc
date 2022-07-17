package com.example.myspring.controller

import com.example.myspring.entity.CountryEntity
import com.example.myspring.dto.CreateTrainingDTO
import com.example.myspring.dto.ExerciseVideoDTO
import com.example.myspring.dto.TrainingDTO
import com.example.myspring.entity.TrainingEntity
import com.example.myspring.service.first_service.MyService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Api("Мой первый контроллер")
class MyController(
    private val service: MyService
) {

    @GetMapping("/countries")
    @ApiOperation("Описание операиции")
    fun fetchCountries(): List<CountryEntity> = service.fetchCountries()

    @GetMapping("/trainings")
    @ApiOperation("Описание операиции")
    fun fetchTrainings(
        @RequestParam("page") page: Int,
    ): List<TrainingDTO> = service.fetchTrainings(page)

    @GetMapping("/exercise/{id}")
    @ApiOperation("Описание операиции")
    fun getExerciseByID(
        @PathVariable("id") id: Int
    ): ExerciseVideoDTO = service.findExerciseByID(id)

    @GetMapping("/{id}")
    @ApiOperation("Описание операиции")
    fun getByID(
        @PathVariable("id") id: Int
    ): TrainingDTO = service.findByID(id)

    @GetMapping("/search")
    @ApiOperation("Описание операиции")
    fun findByName(
        @RequestParam("prefix") prefix: String
    ): List<TrainingDTO> = service.findByName(prefix)

    @PostMapping("/create")
    @ApiOperation("Описание операиции")
    fun createTraining(
        @RequestBody dto: CreateTrainingDTO
    ): TrainingDTO {
        return service.creatTraining(dto)
    }

}