package com.quid.jpahibernate.generator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UuidTypeTest{

    @Autowired
    lateinit var repository: UuidRepository

    @Test
    fun test(){
        val uuidType = UuidType(null, "name")
        repository.save(uuidType)

        assertNotNull(uuidType.id)
            .also { println("uuidType.id: ${uuidType.id}") }
    }
}