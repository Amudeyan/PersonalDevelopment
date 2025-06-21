package com.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.repository",
        transactionManagerRef = "primaryPlatformTransactionManager",
entityManagerFactoryRef = "primaryEntityManagerFactory")
@EntityScan(basePackages = "com.data")
@EnableTransactionManagement
public class CustomDBConfiguration {

    @Bean("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.primary.datasource")
    @Scope(scopeName = "prototype")
    public DataSource dataSource(){
       return DataSourceBuilder.create().build();
    }

    @Bean("primaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("primaryDataSource") DataSource dataSource
    ){
        return builder
                .dataSource(dataSource)
                .persistenceUnit("mydb")
                .build();
    }


    @Bean("primaryPlatformTransactionManager")
    public PlatformTransactionManager platformTransactionManager(
           @Qualifier("primaryEntityManagerFactory") EntityManagerFactory localContainerEntityManagerFactoryBean
    ){
        return new JpaTransactionManager( localContainerEntityManagerFactoryBean);
    }

}
