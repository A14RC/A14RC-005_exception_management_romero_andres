package com.pucetec.products.models.entities

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

@MappedSuperclass

abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long =0

    //createdAt -> created_at
    @Column(name = "created_at")
    val createdAt : LocalDateTime = LocalDateTime.now()


    //isActive -> is_active
    //hasEnsurance -> has_ensurance
    @Column(name = "updated_at")
    val updatedAt : LocalDateTime = LocalDateTime.now()

}