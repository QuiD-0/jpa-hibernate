package com.quid.jpahibernate.transaction.isolation

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@SpringBootTest
@TestConstructor(autowireMode = ALL)
class ServiceATest(
    private val serviceA: ServiceA
) {
    @Test
    @DisplayName("Nested 트랜잭션은 부모 트랜잭션을 롤백 시키지 않음")
    fun nestedTest() {
        val testName = "test 1"
        serviceA.doSomething(testName,true)

        serviceA.findByName(testName)
            ?.let { assert(it.status == "ERROR") }
    }
}