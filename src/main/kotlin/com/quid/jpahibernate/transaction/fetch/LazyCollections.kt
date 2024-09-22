package com.quid.jpahibernate.transaction.fetch

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service

@Entity
class Post(
    val title: String,
    val content: String,
    val author: String,
    @JoinColumn(name = "post_id")
    @OneToMany(fetch = LAZY, cascade = [CascadeType.ALL])
    val comments: MutableList<Comment> = mutableListOf()
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null
}

@Entity
class Comment(
    val review: String,
    val author: String
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null
}

interface PostRepository : JpaRepository<Post, Long>

@Service
class LazyCollections(private val postRepository: PostRepository) {
    fun savePost(post: Post): Post = postRepository.save(post)
    fun getCommentsSize(postId: Long): Int = postRepository.getReferenceById(postId).comments.size
}