package com.quid.jpahibernate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaHibernateApplication

fun main(args: Array<String>) {
    runApplication<JpaHibernateApplication>(*args)
}
