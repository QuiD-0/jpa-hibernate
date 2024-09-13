package com.quid.jpahibernate.transaction

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class SimpleTransactionTest(
    private val simpleTransaction: SimpleTransaction
) {

    @Test
    fun simpleTransactionTest() {
        simpleTransaction.invoke()
        assertTrue(true)
    }
}