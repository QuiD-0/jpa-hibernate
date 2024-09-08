package com.quid.jpahibernate.datajpa

import jakarta.transaction.Transactional
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.TestConstructor
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class UserRepositoryTest(
    private val userRepository: UserJpaRepository
) {

    @Test
    fun saveUser() {
        val user = UserEntity(
            id = 1,
            username = "user",
            registeredDate = LocalDateTime.now(),
            email = "mail.mail.com",
            level = 1,
            active = true
        )

        assertDoesNotThrow { userRepository.save(user) }
        val foundUser = userRepository.findByIdOrNull(1)!!

        assertEquals(user.username, foundUser.username)
    }

    @Test
    fun streamableTest() {
        val toList = userRepository.findByRegisteredDateAfter(LocalDateTime.now())
            .and(userRepository.findByLevel(1))
            .distinct()
            .toList()

        assertNotNull(toList)
    }

    @Test
    @Transactional
    fun streamTest() {
        val toList = userRepository.findByActive(true)
            .filter(UserEntity::active)
            .toList()

        assertNotNull(toList)
    }

}