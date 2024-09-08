package com.quid.jpahibernate.generator

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class UuidTypeTest(
    private val repository: UuidRepository
) {

    @Test
    fun test() {
        val uuidType = UuidType(null, "name")
        repository.save(uuidType)

        assertNotNull(uuidType.id)
            .also { println("uuidType.id: ${uuidType.id}") }
    }
}