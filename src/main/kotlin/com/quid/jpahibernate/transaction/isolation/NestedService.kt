package com.quid.jpahibernate.transaction.isolation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class NestedService {

    @Transactional(propagation = Propagation.NESTED)
    fun nestedTransaction(error: Boolean) {
        if (error) {
            throw RuntimeException("Error")
        }
    }
}