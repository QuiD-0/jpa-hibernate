package com.quid.jpahibernate.generator

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UuidRepository: JpaRepository<UuidType, UUID> {
}