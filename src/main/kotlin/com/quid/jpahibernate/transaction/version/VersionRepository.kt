package com.quid.jpahibernate.transaction.version

import org.springframework.data.jpa.repository.JpaRepository

interface VersionRepository: JpaRepository<DateTimeVersion, Long> {
}