package com.quid.jpahibernate.transaction.propagation

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class MandatoryService {

    @Transactional(propagation = Propagation.MANDATORY)
    fun mandatory(): Boolean {
        return true
    }
}