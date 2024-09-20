package com.quid.jpahibernate

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class TestDataSourceConfig {

    @Bean
    fun testDataSource(): HikariDataSource =
        HikariDataSource().apply {
            jdbcUrl = "jdbc:mysql://localhost:3306/jpa"
            username = "root"
            password = "root"
            driverClassName = "com.mysql.cj.jdbc.Driver"
        }
}