package com.quid.jpahibernate.transaction.propagation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class RequireNewService(
    private val apiHistory: ApiHistoryRepository
) {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun requireNew(history: ApiHistory) {
        history.updateStatus("CHILD TRANSACTION")
            .let { apiHistory.save(it) }
    }
}