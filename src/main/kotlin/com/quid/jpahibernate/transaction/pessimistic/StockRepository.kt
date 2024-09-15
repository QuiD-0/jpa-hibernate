package com.quid.jpahibernate.transaction.pessimistic

import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock

interface StockRepository: JpaRepository<Stock, Long> {
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    fun findByIdWithPessimisticRead(id: Long): Stock?

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    fun findByIdWithPessimisticWrite(id: Long): Stock?
}