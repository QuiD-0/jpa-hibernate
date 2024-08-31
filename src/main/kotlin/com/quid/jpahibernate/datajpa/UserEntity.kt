package com.quid.jpahibernate.datajpa

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "USERS")
class UserEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "NAME")
    val username: String,
    @Column(name = "REGISTERED_DATE")
    val registeredDate: LocalDateTime,
    @Column(name = "EMAIL")
    val email: String,
    @Column(name = "LEVEL")
    val level: Int,
    @Column(name = "ACTIVE")
    val active: Boolean
) {
}