package com.quid.jpahibernate.annotations

import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository: JpaRepository<Item, Long> {
}