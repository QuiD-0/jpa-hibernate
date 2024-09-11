package com.quid.jpahibernate.naturalId

import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component

@Component
class ProductNaturalRepository(
    private val em: EntityManager
) {
    fun findByNaturalId(naturalId: String): Product? {
        return em.unwrap(org.hibernate.Session::class.java)
            .bySimpleNaturalId(Product::class.java)
            .load(naturalId)
    }
}