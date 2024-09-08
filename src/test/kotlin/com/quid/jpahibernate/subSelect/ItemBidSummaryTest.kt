package com.quid.jpahibernate.subSelect

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.simple.JdbcClient
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class ItemBidSummaryTest(
    private val jdbcClient: JdbcClient,
    private val repository: ItemBidSummaryRepository
) {

    @Test
    fun findSubSelect() {
        repository.findAll().also { println(it) }
    }

    @Test
    fun setup() {
        val insertItems: String = """
            insert into item (id, name, price) values (1, 'item1', 100), (2, 'item2', 200), (3, 'item3', 300);
        """.trimIndent()

        val insertBids: String = """
            insert into bid (id, amount, itemId) values (1, 100, 1), (2, 200, 1), (3, 300, 1), (4, 400, 2), (5, 500, 2), (6, 600, 3);
        """.trimIndent()

        jdbcClient.sql(insertItems).update()
        jdbcClient.sql(insertBids).update()
    }

}