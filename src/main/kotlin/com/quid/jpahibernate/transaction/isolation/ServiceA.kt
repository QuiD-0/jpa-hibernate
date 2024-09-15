package com.quid.jpahibernate.transaction.isolation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ServiceA(
    private val apiHistory: ApiHistoryRepository,
    private val serviceB: ServiceB
) {

    @Transactional
    fun doSomething(name: String, error: Boolean) {
        val init = ApiHistory(name, "REQUEST")
            .let { apiHistory.save(it) }

        try {
            serviceB.doSomething(error)
            apiHistory.save(init.updateStatus("SUCCESS"))
        } catch (e: Exception) {
            apiHistory.save(init.updateStatus("ERROR"))
        }
    }

    fun findByName(testName: String): ApiHistory? {
        return apiHistory.findByName(testName)
    }
}