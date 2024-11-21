package com.example.springBatch.configuration;

import ch.qos.logback.classic.Logger;
import com.example.springBatch.data.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class MyItemProcessor implements ItemProcessor<Users, Users> {
    @Override
    public Users process(Users item) throws Exception {
        return item;
    }
}
