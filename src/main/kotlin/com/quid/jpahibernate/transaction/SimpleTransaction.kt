package com.quid.jpahibernate.transaction

import com.quid.jpahibernate.mapping.Phone
import jakarta.persistence.EntityManager
import jakarta.persistence.Persistence

class SimpleTransaction {
    private val entityManagerFactory = Persistence.createEntityManagerFactory("entity-manager")
    private val entityManager: EntityManager = entityManagerFactory.createEntityManager()

    fun invoke() {
        entityManager.use {
            try {
                it.transaction.begin()
                val phone = Phone(
                    number = "123456789",
                    type = "IOS"
                )
                phone.addDetails("Apple")
                it.persist(phone)
                it.transaction.commit()
            } catch (e: Exception) {
                it.transaction.rollback()
            }
        }
    }

}