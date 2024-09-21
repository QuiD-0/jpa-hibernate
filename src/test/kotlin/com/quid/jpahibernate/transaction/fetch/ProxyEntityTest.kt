package com.quid.jpahibernate.transaction.fetch

import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = ALL)
class ProxyEntityTest(
    private val proxyEntityRepository: ProxyEntityRepository,
    private val proxyEntityService: ProxyEntityService,
) {

    @Test
    fun testGetReference() {
        val proxyEntity = ProxyEntity("name", "description")
        val id = proxyEntityRepository.save(proxyEntity).id!!
        val reference = proxyEntityService.getReference(id)
        assertNotEquals(proxyEntity, reference)
    }
}