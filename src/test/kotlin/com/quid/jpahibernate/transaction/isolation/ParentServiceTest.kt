package com.quid.jpahibernate.transaction.isolation

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.transaction.IllegalTransactionStateException

@SpringBootTest
@TestConstructor(autowireMode = ALL)
class ParentServiceTest(
    private val parentService: ParentService
) {
    @Test
    @DisplayName("Nested 트랜잭션은 부모 트랜잭션을 롤백 시키지 않음")
    fun nestedTest() {
        val testName = "test 1"
        parentService.nested(testName,true)

        parentService.findByName(testName)
            ?.let { assert(it.status == "ERROR") }
    }

    @Test
    @DisplayName("Mandatory 트랜잭션은 부모 트랜잭션을 이어감")
    fun mandatoryTest() {
        assertDoesNotThrow { parentService.mandatory(true) }
    }

    @Test
    @DisplayName("Mandatory 트랜잭션은 부모 트랜잭션이 없으면 예외 발생")
    fun mandatoryExceptionTest() {
        assertThrows<IllegalTransactionStateException> { parentService.mandatory(false) }
    }
}