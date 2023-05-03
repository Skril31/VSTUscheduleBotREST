package com.example.botsceduleapp.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
@Configuration
@EnableJpaRepositories(basePackages = "com.example.botsceduleapp.repository.schedule",
        entityManagerFactoryRef = "scheduleEntityManagerFactory",
        transactionManagerRef= "scheduleTransactionManager")
public class ScheduleDataSourceConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.schedule")
    public DataSourceProperties cardDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.schedule.configuration")
    public DataSource cardDataSource() {
        return cardDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "scheduleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean scheduleEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(cardDataSource())
                .packages("com.example.botsceduleapp.model.Schedule")
                .build();
    }

    @Bean
    public PlatformTransactionManager scheduleTransactionManager(
            final @Qualifier("scheduleEntityManagerFactory") LocalContainerEntityManagerFactoryBean scheduleEntityManagerFactory) {
        return new JpaTransactionManager(scheduleEntityManagerFactory.getObject());
    }

}
