package com.example.springBatch;

import com.example.springBatch.configuration.BasicConfig;
import com.example.springBatch.data.Users;
import com.example.springBatch.data.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.example/springBatch")
//@EnableBatchProcessing
@EnableJpaRepositories(basePackages = "com.example.springBatch.data")
@AllArgsConstructor
public class SpringBatchApplication implements CommandLineRunner {

	//@Autowired
	private JobLauncher jobLauncher;
	//@Autowired
	BasicConfig basicConfig;
	//@Autowired
	private Job job;
	private UsersRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Users users = new Users();
		users.setName("Aravinth");
		users.setPath("AravinthPath");
		Users users1 = new Users("Aravinth","AravinthPath");
		Users users2 = new Users("Aravinth","AravinthPath");
		Users users3 = new Users("Aravinth","AravinthPath");
		List<Users> usersList= Arrays.asList(users,users1,users2,users3);
		usersRepository.saveAll(usersList);
		JobParameters jobParameters = new JobParametersBuilder().addDouble("param", 1.0).toJobParameters();
		jobLauncher.run(job,jobParameters);
		//basicConfig.jobLauncher();
	}
}
