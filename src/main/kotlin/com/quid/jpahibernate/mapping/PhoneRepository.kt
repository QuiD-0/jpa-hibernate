package com.quid.jpahibernate.mapping

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class PhoneRepository(
    private val phoneJpaRepository: PhoneJpaRepository
) {
    fun findById(id: Long): Phone? {
        return phoneJpaRepository.findByIdOrNull(id)
    }

    fun save(phone: Phone) {
        phoneJpaRepository.save(phone)
    }
}

interface PhoneJpaRepository : JpaRepository<Phone, Long> {
}