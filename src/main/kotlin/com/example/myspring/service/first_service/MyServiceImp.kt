package com.example.myspring.service.first_service

import com.example.myspring.entity.CountryEntity
import com.example.myspring.exception.TrainingNotFoundException
import com.example.myspring.dto.CreateTrainingDTO
import com.example.myspring.dto.ExerciseVideoDTO
import com.example.myspring.dto.TrainingDTO
import com.example.myspring.entity.TrainingEntity
import com.example.myspring.repository.ExerciseRepository
import com.example.myspring.repository.TrainingRepository
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MyServiceImp(
    private val trainingsRepo: TrainingRepository,
    private val exerciseRepository: ExerciseRepository,
) : MyService {

    private val log = LoggerFactory.getLogger(this.javaClass)

    override fun fetchCountries(): List<CountryEntity> {
        return listOf(
            CountryEntity(id = 1, name = "France", population = 56_000_000),
            CountryEntity(id = 2, name = "Russia", population = 146_000_000),
            CountryEntity(id = 3, name = "Germany", population = 86_000_000),
            CountryEntity(id = 4, name = "Italy", population = 53_000_000),
        )
    }

    override fun fetchTrainings(page: Int): List<TrainingDTO> {
        return trainingsRepo.findByOrderByNameAsc(PageRequest.of(page, 5))
            .map { it.toDTO() }
    }

    override fun findByID(id: Int): TrainingDTO {
        return trainingsRepo.findByIdOrNull(id)?.toDTO() ?: throw TrainingNotFoundException()
    }

    override fun findByName(prefix: String): List<TrainingDTO> {
        return trainingsRepo.findByNameStartingWithIgnoreCaseOrderByName(prefix)
            .map { it.toDTO() }
    }

    override fun creatTraining(dto: CreateTrainingDTO): TrainingDTO {
        return trainingsRepo.save(dto.toEntity()).toDTO()
    }

    override fun findExerciseByID(id: Int): ExerciseVideoDTO {
        return exerciseRepository.findByIdOrNull(id)?.toDTO() ?: throw TrainingNotFoundException()
    }

//    @Transactional
//    override fun creatTraining(dto: TrainingDTO): TrainingDTO {
//        trainingsRepo.save(dto.toEntity()).toDTO()
//        trainingsRepo.save(dto.toEntity()).toDTO()
//        throw TrainingNotFoundException()
//        return trainingsRepo.save(dto.toEntity()).toDTO()
//    }


}