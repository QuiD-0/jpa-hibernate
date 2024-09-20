package com.quid.jpahibernate.transaction.propagation

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