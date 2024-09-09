package com.quid.jpahibernate.subSelect

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class ItemTest(
    private val repository: ItemRepository
) {

    @Test
    fun findWithFormula() {
        repository.findAll().also { println(it) }
    }
}