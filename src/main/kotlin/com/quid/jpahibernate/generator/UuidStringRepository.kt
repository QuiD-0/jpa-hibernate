package com.quid.jpahibernate.generator

import org.springframework.data.jpa.repository.JpaRepository

interface UuidStringRepository : JpaRepository<UuidStringType, String> {
}