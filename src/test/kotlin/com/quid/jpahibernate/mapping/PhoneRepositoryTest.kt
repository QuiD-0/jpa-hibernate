package com.quid.jpahibernate.mapping

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class PhoneRepositoryTest(
    private val phoneRepository: PhoneRepository
){
    @Test
    fun save() {
        val phone = Phone(
            number = "123456789",
            type = "IOS"
        )
        phone.addDetails("Apple")
        phoneRepository.save(phone)

        assertEquals(phone.id, phone.details?.id)
    }

}