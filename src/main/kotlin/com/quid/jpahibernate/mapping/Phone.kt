package com.quid.jpahibernate.mapping

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne

@Entity
class Phone(
    val number: String,
    val type: String,
) {
    @OneToOne(mappedBy = "phone", cascade = [CascadeType.ALL])
    var details: PhoneDetails? = null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun addDetails(provider: String) {
        details = PhoneDetails(this, provider)
    }
}