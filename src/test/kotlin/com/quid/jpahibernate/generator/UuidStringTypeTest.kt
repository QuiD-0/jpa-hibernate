package com.quid.jpahibernate.generator

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import kotlin.test.assertNotNull

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class UuidStringTypeTest(
    private val repository: UuidStringRepository
) {

    @Test
    fun test() {
        val uuidStringType = UuidStringType(null, "name")
        repository.save(uuidStringType)

        assertNotNull(uuidStringType.id)
            .also { println("uuidStringType.id: ${uuidStringType.id}") }
    }
}