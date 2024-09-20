package com.quid.jpahibernate.transaction.propagation

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository

@Entity
class ApiHistory(
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,
    val name: String,
    val status: String,
) {
    constructor(name: String, status: String) : this(null, name, status)

    fun updateStatus(status: String): ApiHistory = ApiHistory(this.id, this.name, status)
}

interface ApiHistoryRepository : JpaRepository<ApiHistory, Long> {
    fun findByName(testName: String): ApiHistory?
}