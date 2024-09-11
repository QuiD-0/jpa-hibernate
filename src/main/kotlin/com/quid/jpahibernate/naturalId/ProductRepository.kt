package com.quid.jpahibernate.naturalId

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class ProductRepository(
    private val jpaRepository: ProductJpaRepository,
    private val naturalRepository: ProductNaturalRepository
) {

    fun findById(id: Long): Product? {
        return jpaRepository.findByIdOrNull(id)
    }

    fun findByNaturalId(naturalId: String): Product? {
        return naturalRepository.findByNaturalId(naturalId)
    }

    @Transactional
    fun save(product: Product) {
        jpaRepository.save(product)
    }
}