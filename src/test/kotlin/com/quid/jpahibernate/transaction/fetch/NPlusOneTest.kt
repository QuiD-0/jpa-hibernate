package com.quid.jpahibernate.transaction.fetch

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.transaction.annotation.Transactional
import kotlin.test.assertNotNull

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = ALL)
@TestMethodOrder(value = OrderAnnotation::class)
class NPlusOneTest(
    private val nPlusOne: NPlusOne
) {

    @Test
    @Order(1)
    fun save() {
        val orders = Orders().apply {
            items.add(LineItem("item1", 1, 100.0))
            items.add(LineItem("item2", 2, 200.0))
            items.add(LineItem("item3", 3, 300.0))
            items.add(LineItem("item4", 4, 400.0))
            items.add(LineItem("item5", 5, 500.0))
            items.add(LineItem("item6", 6, 600.0))
            items.add(LineItem("item7", 7, 700.0))
            items.add(LineItem("item8", 8, 800.0))
            items.add(LineItem("item9", 9, 900.0))
            items.add(LineItem("item10", 10, 1000.0))
        }
        nPlusOne.saveOrder(orders)
    }

    @Test
    @Order(2)
    @Transactional
    @DisplayName("Lazy 로딩시 n+1개의 쿼리가 발생한다.")
    fun `n+1`() {
        nPlusOne.findOrder(1L).forEach {
            println(it.items)
        }
    }

}