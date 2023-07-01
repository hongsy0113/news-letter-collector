package com.yooni.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.persistence.EntityManagerFactory

@Configuration
class DataSourceConfiguration {

    @Primary
    @Bean
    fun newsLetterCollectorTransactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager =
        JpaTransactionManager().apply {
            setEntityManagerFactory(entityManagerFactory)
        }
}