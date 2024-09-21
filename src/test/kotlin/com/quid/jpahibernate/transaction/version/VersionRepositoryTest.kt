package com.quid.jpahibernate.transaction.version

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = ALL)
class VersionRepositoryTest(
    private val repository: VersionRepository
) {

    @Test
    fun saveNew() {
        DateTimeVersion(10)
            .let { repository.save(it) }
            .also { println(it) }
    }

}