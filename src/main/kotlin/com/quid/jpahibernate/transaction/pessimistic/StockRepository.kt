package com.quid.jpahibernate.transaction.pessimistic

import jakarta.persistence.LockModeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

interface StockJpaRepository : JpaRepository<Stock, Long> {
}

@Repository
class StockRepository(
    private val stockRepository: StockJpaRepository
) {
    @Lock(value = LockModeType.PESSIMISTIC_READ)
    fun findByIdPessimisticRead(id: Long): Stock? {
        return stockRepository.findByIdOrNull(id)
    }

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    fun findByIdWithPessimisticWrite(id: Long): Stock? {
        return stockRepository.findByIdOrNull(id)
    }
}