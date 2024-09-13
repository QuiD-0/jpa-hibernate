package com.quid.jpahibernate.transaction

import com.quid.jpahibernate.mapping.Phone
import jakarta.persistence.EntityManager
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class GetReference(
    val entityManager: EntityManager
) {
    val log = LoggerFactory.getLogger(this::class.java)!!

    @Transactional(readOnly = true)
    fun invoke() {
        val reference = entityManager.getReference(Phone::class.java, 1L)
        log.info("Reference: $reference")
    }
}