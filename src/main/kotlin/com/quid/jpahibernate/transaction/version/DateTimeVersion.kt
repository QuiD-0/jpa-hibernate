package com.quid.jpahibernate.transaction.version

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Version
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
class DateTimeVersion(
    val stock: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @CreationTimestamp
    val regDate: LocalDateTime? = null

    @Version
    @UpdateTimestamp
    @Column(insertable = false)
    val modDate: LocalDateTime? = null

    override fun toString(): String {
        return "DateTimeVersion(stock=$stock, id=$id, regDate=$regDate, modDate=$modDate)"
    }
}