package com.example.springBatch.configuration;

import com.example.springBatch.data.Users;
import com.example.springBatch.data.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

@AllArgsConstructor
@NoArgsConstructor
public class MyItemReader implements ItemReader<Users> {
    UsersRepository usersRepository;
    @Override
    public Users read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
     //iterator = users
       return null;
    }
}
