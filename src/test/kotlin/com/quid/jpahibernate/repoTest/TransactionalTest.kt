package com.quid.jpahibernate.repoTest

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager

@Transactional
@SpringBootTest
@ActiveProfiles("dev")
class TransactionalTest {

    @BeforeEach
    fun beforeEach() {
        println("===== Before Each =====")
        TransactionSynchronizationManager.isActualTransactionActive()
            .also { println("Transaction Active: $it") }
    }

    @RepeatedTest(2)
    fun `transactional test`() {
        println("===== Repeated Test =====")
        TransactionSynchronizationManager.isActualTransactionActive()
            .also { println("Transaction Active: $it") }
    }

    @AfterEach
    fun afterEach() {
        println("===== After Each =====")
        TransactionSynchronizationManager.isActualTransactionActive()
            .also { println("Transaction Active: $it") }
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun beforeAll(): Unit {
            println("===== Before All =====")
            TransactionSynchronizationManager.isActualTransactionActive()
                .also { println("Transaction Active: $it") }
        }

        @JvmStatic
        @AfterAll
        fun afterAll(): Unit {
            println("===== After All =====")
            TransactionSynchronizationManager.isActualTransactionActive()
                .also { println("Transaction Active: $it") }
        }
    }
}