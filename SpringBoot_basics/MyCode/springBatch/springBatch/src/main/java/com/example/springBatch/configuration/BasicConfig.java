package com.example.springBatch.configuration;

import com.example.springBatch.data.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.*;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@AllArgsConstructor

public class BasicConfig {
    @Bean
    public StepExecutionListener stepExecutionListener(){
        return new MyStepExecutionListener();
    }
    @Bean
    public SkipListener<Users, Users> skipListener() {
        return new MySkipListener();
    }
    @Bean
    public JobExecutionListener jobExecutionListener(){
        return new MyJobExecutionListener();
    }
    @Bean("step")
    public Step step(PlatformTransactionManager platformTransactionManager, JobRepository jobRepository, JpaPagingItemReader<Users> jpaPagingItemReader,
                     ItemReader<Users> itemReader, ItemWriter<Users> itemWriter, ItemProcessor<Users,Users> itemProcessor, JdbcPagingItemReader<Users> jdbcPagingItemReader,
                     StepExecutionListener stepExecutionListener,SkipListener skipListener){

        return new StepBuilder("step",jobRepository)
                .<Users,Users>chunk(1,platformTransactionManager)
//                .reader(itemReader)
                .reader(jdbcPagingItemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(20)
               // .startLimit(5)
                .listener(stepExecutionListener)
                .listener(skipListener)
                .build();
    }
    @Bean("job")
    public Job job(Step step,JobRepository jobRepository,JobExecutionListener jobExecutionListener){
        return new JobBuilder("Job",jobRepository)
//                .incrementer(new RunIdIncrementer())
                .start(step)
                .listener(jobExecutionListener)
                .build();
    }
}
