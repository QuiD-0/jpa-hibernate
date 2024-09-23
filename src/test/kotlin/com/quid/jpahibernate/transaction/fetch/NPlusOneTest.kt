package com.quid.jpahibernate.transaction.fetch

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.transaction.annotation.Transactional
import kotlin.test.assertNotNull

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = ALL)
class NPlusOneTest(
    private val nPlusOne: NPlusOne
) {

    @Test
    @Order(1)
    fun save() {
        val orders = Orders(LineItem("item1", 1, 100.0))
        nPlusOne.saveOrder(orders)
    }

    @Test
    @Order(2)
    @Transactional
    @DisplayName("Lazy 로딩시 n+1개의 쿼리가 발생한다.")
    fun `n+1`() {
        nPlusOne.findOrder(1L).forEach {
            assertNotNull(it.items)
        }
    }

}