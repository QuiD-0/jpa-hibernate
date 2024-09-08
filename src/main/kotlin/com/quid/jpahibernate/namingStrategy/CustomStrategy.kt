package com.quid.jpahibernate.namingStrategy

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class CustomStrategy{

    @Bean
    fun physicalNamingStrategy(): PhysicalNamingStrategyStandardImpl {
        return CusStrategy()
    }

    class CusStrategy: PhysicalNamingStrategyStandardImpl() {
        override fun toPhysicalTableName(logicalName: Identifier?, context: JdbcEnvironment?): Identifier {
            return Identifier(namingStrategy(logicalName), logicalName?.isQuoted ?: false)
        }

        private fun namingStrategy(logicalName: Identifier?): String {
            return "TEST_${logicalName?.text?.uppercase(Locale.getDefault())}"
        }
    }
}