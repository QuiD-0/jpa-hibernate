package com.quid.jpahibernate.subSelect

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Formula

@Entity
@Table(name = "ITEM")
class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val price: Double,
    val description: String,
    @Formula("concat(substring(description, 1, 10), '...')")
    val shortDescription: String
) {
    override fun toString(): String {
        return "Item(id=$id, name='$name', price=$price, description='$description', shortDescription='$shortDescription')"
    }
}