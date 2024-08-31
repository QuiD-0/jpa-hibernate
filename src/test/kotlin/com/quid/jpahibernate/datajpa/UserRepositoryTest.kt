package com.quid.jpahibernate.datajpa

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import java.time.LocalDateTime
import kotlin.test.assertEquals

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {

    @Autowired
    lateinit var userRepository: UserJpaRepository

    @Test
    fun `should save user`() {
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

}