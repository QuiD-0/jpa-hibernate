package com.quid.jpahibernate.transaction.isolation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class ServiceB {

    @Transactional(propagation = Propagation.NESTED)
    fun doSomething(error: Boolean) {
        if (error) {
            throw RuntimeException("Error")
        }
    }
}