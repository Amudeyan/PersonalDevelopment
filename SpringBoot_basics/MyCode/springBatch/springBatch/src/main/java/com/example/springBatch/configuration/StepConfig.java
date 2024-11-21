package com.example.springBatch.configuration;

import com.example.springBatch.data.Users;
import jakarta.persistence.EntityManagerFactory;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Configuration
@NoArgsConstructor
public class StepConfig {

    @Bean("itemReader")
    public ItemReader<Users> itemReader(){
        return new MyItemReader();
    }
    @Bean
    public ItemProcessor<Users,Users> itemProcessor(){
        return new MyItemProcessor();
    }
    @Bean
    public ItemWriter<Users> itemWriter(){
        return new MyItemWriter();
    }
    @Bean
    public RowMapper<Users> usersRowMapper(){
        return new UsersRowMappper();
    }
    @Bean
    public PagingQueryProvider queryProvider(DataSource dataSource) throws Exception {
        SqlPagingQueryProviderFactoryBean provider = new SqlPagingQueryProviderFactoryBean();

        provider.setDataSource(dataSource);
        provider.setSelectClause("select id, name, path");
        provider.setFromClause("from users");
        // provider.setWhereClause("where status=:status");
        provider.setSortKey("id");

        return provider.getObject();
    }
    @Bean
    public JdbcPagingItemReader jdbcPagingItemReader(DataSource dataSource, RowMapper rowMapper, PagingQueryProvider pagingQueryProvider) throws Exception {


        return new JdbcPagingItemReaderBuilder<Users>()
                .name("JdbcPagingItemReaderBuilder")
                .dataSource(dataSource)
                //.beanRowMapper(new BeanPropertyRowMapper<Users>(Users.class))
                .queryProvider(pagingQueryProvider)
                .fetchSize(1)
                .rowMapper(rowMapper)
                //.parameterValues(parameterValues)
                .pageSize(1)
                .build();
    }
    @Bean
    public JpaPagingItemReader JpaPagingItemReader(EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<Users>()
                .name("JpaPagingItemReader")
                .entityManagerFactory(entityManagerFactory)
               // .entityManagerFactory(entityManagerFactory())
                .queryString("select c.id,c.name,c.path from Users c")
                .pageSize(1)
                .saveState(true)
                .build();
    }



}
