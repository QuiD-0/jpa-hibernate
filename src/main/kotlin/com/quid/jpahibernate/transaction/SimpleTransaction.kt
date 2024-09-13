package com.quid.jpahibernate.transaction

import com.quid.jpahibernate.mapping.Phone
import jakarta.persistence.EntityManagerFactory
import org.springframework.stereotype.Component

@Component
class SimpleTransaction(
    private val entityManagerFactory: EntityManagerFactory
) {

    fun invoke() {
        entityManagerFactory.createEntityManager().use {
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