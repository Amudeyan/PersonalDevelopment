package com.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
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
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "com.configuration.seconddb")
@EnableJpaRepositories(entityManagerFactoryRef = "secondEntityManagerFactory",
transactionManagerRef = "secondPlatformTransactionManager",
        basePackages = "com.configuration.repo"        )
public class CustomSecondDataBaseConfiguration {

    @ConfigurationProperties(prefix = "spring.second.datasource")
    @Bean("secondDataSource")
       public DataSource secongDataSource(){
        return DataSourceBuilder.create().build();
    }



 @Bean("secondEntityManagerFactory")
    @ConditionalOnBean(name = "secondEntityManagerFactory",search = SearchStrategy.ALL)
    public LocalContainerEntityManagerFactoryBean factoryBean(
        EntityManagerFactoryBuilder builder,
        @Qualifier("secondDataSource") DataSource datasource
    ){
        return  builder
                .dataSource(datasource)
                .persistenceUnit("second")
                .build();
    }



    /*@Bean(name = "secondEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
            @Qualifier("secondDataSource") DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.example.demo.second.entity");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProps = new Properties();
        jpaProps.put("hibernate.hbm2ddl.auto", "update");
        jpaProps.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        jpaProps.put("hibernate.show_sql", "true");
        emf.setJpaProperties(jpaProps);

        return emf;
    }*/

    @Bean("secondPlatformTransactionManager")
    public PlatformTransactionManager platformTransactionManager(
            @Qualifier("secondEntityManagerFactory")EntityManagerFactory entityManagerFactory
            ){
            return new JpaTransactionManager( entityManagerFactory);
    }
}
