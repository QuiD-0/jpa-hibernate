package com.quid.jpahibernate.subSelect

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
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
    fun findWithPageable() {
        val page: Pageable = PageRequest.of(0, 1)
        repository.findAll(page)
    }

    @Test
    fun setup() {
        val insertItems: String = """
            insert into item (id, name, price, description) values (1, 'item1', 100, 'this is item1 description'), (2, 'item2', 200, 'this is item2 description'), (3, 'item3', 300, 'this is item3 description');
        """.trimIndent()

        val insertBids: String = """
            insert into bid (id, amount, itemId) values (1, 100, 1), (2, 200, 1), (3, 300, 1), (4, 400, 2), (5, 500, 2), (6, 600, 3);
        """.trimIndent()

        jdbcClient.sql(insertItems).update()
        jdbcClient.sql(insertBids).update()
    }

}