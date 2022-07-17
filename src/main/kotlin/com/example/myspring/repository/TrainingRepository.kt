package com.example.myspring.repository

import com.example.myspring.entity.TrainingEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository


interface TrainingRepository: CrudRepository<TrainingEntity, Int> {

    fun findByOrderByNameAsc(pageable: Pageable): List<TrainingEntity>

    fun findByNameStartingWithIgnoreCaseOrderByName(prefix: String): List<TrainingEntity>

}