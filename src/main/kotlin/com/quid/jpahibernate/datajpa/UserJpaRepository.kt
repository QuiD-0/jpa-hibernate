package com.quid.jpahibernate.datajpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.util.Streamable
import java.time.LocalDateTime
import java.util.stream.Stream

interface UserJpaRepository: JpaRepository<UserEntity, Long>{
    fun findByRegisteredDateAfter(date: LocalDateTime): Streamable<UserEntity>
    fun findByLevel(level: Int): Streamable<UserEntity>
    fun findByActive(active: Boolean): Stream<UserEntity>
}