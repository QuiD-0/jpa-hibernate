package com.quid.jpahibernate.generator

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertNotNull

@SpringBootTest
class UuidStringTypeTest {

    @Autowired
    lateinit var repository: UuidStringRepository

    @Test
    fun test() {
        val uuidStringType = UuidStringType(null, "name")
        repository.save(uuidStringType)

        assertNotNull(uuidStringType.id)
            .also { println("uuidStringType.id: ${uuidStringType.id}") }
    }
}