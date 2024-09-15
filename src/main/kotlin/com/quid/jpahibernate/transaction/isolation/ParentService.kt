package com.quid.jpahibernate.transaction.isolation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionTemplate

@Service
class ParentService(
    private val apiHistory: ApiHistoryRepository,
    private val nestedService: NestedService,
    private val mandatoryService: MandatoryService,
    private val transaction: TransactionTemplate
) {

    @Transactional
    fun nested(name: String, error: Boolean) {
        val init = ApiHistory(name, "REQUEST")
            .let { apiHistory.save(it) }

        try {
            nestedService.nestedTransaction(error)
            apiHistory.save(init.updateStatus("SUCCESS"))
        } catch (e: Exception) {
            apiHistory.save(init.updateStatus("ERROR"))
        }
    }

    fun mandatory(transaction: Boolean) {
        if (transaction) {
            this.transaction.execute {
                mandatoryService.mandatory()
            }
        } else {
            mandatoryService.mandatory()
        }
    }

    fun findByName(testName: String): ApiHistory? {
        return apiHistory.findByName(testName)
    }
}