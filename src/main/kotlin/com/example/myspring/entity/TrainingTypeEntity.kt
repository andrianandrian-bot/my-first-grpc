package com.example.myspring.entity

import javax.persistence.*

@Entity
@Table(name = "training_types")
class TrainingTypeEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,

//    @OneToMany(mappedBy = "type")
//    val training: List<TrainingEntity> = emptyList()
)