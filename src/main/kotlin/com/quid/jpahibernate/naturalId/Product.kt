package com.quid.jpahibernate.naturalId

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import org.hibernate.annotations.NaturalId
import java.math.BigDecimal

@Entity
class Product(
    @NaturalId
    @Column(unique = true, nullable = false, updatable = false)
    val productKey: String,
    val name: String,
    val price: BigDecimal
) {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
}