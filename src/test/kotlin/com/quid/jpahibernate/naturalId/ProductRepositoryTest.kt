package com.quid.jpahibernate.naturalId

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.util.*

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class ProductRepositoryTest(
    private val productRepository: ProductRepository
) {

    @Test
    @Transactional(readOnly = true)
    fun findById() {
        val product = productRepository.findById(1)
        productRepository.findById(1)
        productRepository.findById(1)
        assertNotNull(product)
        assertEquals("Product 1", product!!.name)
    }

    @Test
    @Transactional(readOnly = true)
    fun findByNaturalId() {
        val product = productRepository.findByNaturalId(key)
        productRepository.findByNaturalId(key)
        productRepository.findByNaturalId(key)
        assertNotNull(product)
        assertEquals("Product 1", product!!.name)
    }

    companion object {
        private val key = UUID.randomUUID().toString()

        @BeforeAll
        @JvmStatic
        fun beforeAll(@Autowired productRepository: ProductRepository) {
            val product = Product(key, "Product 1", BigDecimal(100.0))
            productRepository.save(product)
            assertNotNull(product.id)
        }
    }
}