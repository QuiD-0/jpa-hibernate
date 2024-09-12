package com.quid.jpahibernate.mapping

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne

@Entity
class PhoneDetails(
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    val phone: Phone,
    val provider: String
) {
    @Id
    var id: Long? = null
}