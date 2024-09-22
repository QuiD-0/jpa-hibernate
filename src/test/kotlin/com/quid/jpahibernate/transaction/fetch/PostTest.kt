package com.quid.jpahibernate.transaction.fetch

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.transaction.annotation.Transactional
import kotlin.test.assertEquals

@SpringBootTest
@ActiveProfiles("dev")
@TestConstructor(autowireMode = ALL)
class PostTest(
    private val lazyCollections: LazyCollections
) {
    @Test
    @Order(1)
    fun savePost() {
        val comment1 = Comment(
            review = "Comment 1 review",
            author = "Comment 1 author"
        )
        val comment2 = Comment(
            review = "Comment 2 review",
            author = "Comment 2 author"
        )
        val post = Post(
            title = "Post title",
            content = "Post content",
            author = "Post author",
            comments = mutableListOf(
                comment1,
                comment2
            )
        )

        assertDoesNotThrow { lazyCollections.savePost(post) }
    }

    @Test
    @Order(2)
    @Transactional
    fun getCommentsSize() {
        assertEquals(2, lazyCollections.getCommentsSize(1))
    }
}
