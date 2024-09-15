package com.quid.jpahibernate.transaction.isolation

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