package com.quid.jpahibernate.transaction.fetch

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Entity
class ProxyEntity(
    val name: String,
    val description: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}

interface ProxyEntityRepository: JpaRepository<ProxyEntity, Long>

@Service
class ProxyEntityService(
    private val proxyEntityRepository: ProxyEntityRepository,
) {
    fun getReference(id: Long): ProxyEntity {
        return proxyEntityRepository.getReferenceById(id)
    }
}