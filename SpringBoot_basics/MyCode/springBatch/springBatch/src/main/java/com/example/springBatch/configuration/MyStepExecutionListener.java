package com.example.springBatch.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

@Slf4j
public class MyStepExecutionListener implements StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("before step : "+ stepExecution.getStartTime());

        // StepExecutionListener.super.beforeStep(stepExecution);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.error(stepExecution.toString());
        System.out.println("after step : "+ stepExecution.getEndTime());
         return StepExecutionListener.super.afterStep(stepExecution);
        //return ExitStatus.COMPLETED;
    }
}
