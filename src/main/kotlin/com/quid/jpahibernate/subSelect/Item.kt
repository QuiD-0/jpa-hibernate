package com.quid.jpahibernate.subSelect

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.Formula
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "ITEM")
@DynamicInsert
@DynamicUpdate
class Item(
    val name: String,
    val price: Double,
    val description: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Formula("concat(substring(description, 1, 10), '...')")
    val shortDescription: String? = null

    @CreationTimestamp
    val createdAt: LocalDateTime? = null

    @ColumnDefault("100")
    val initialPrice: BigDecimal? = null

    override fun toString(): String {
        return "Item(id=$id, name='$name', price=$price, description='$description', shortDescription='$shortDescription')"
    }
}