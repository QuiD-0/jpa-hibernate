package com.quid.jpahibernate.annotations

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class ItemTest(
    private val repository: ItemRepository
) {

    @Test
    fun findWithFormula() {
        repository.findAll().also { println(it) }
    }

    @Test
    fun save() {
        val item = Item(
            name = "item1",
            price = 100.0,
            description = "this is item1 description"
        )
        repository.save(item)
    }
}