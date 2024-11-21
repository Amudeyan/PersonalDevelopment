package com.example.springBatch.configuration;

import com.example.springBatch.data.Users;
import com.example.springBatch.data.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
public class MyItemWriter implements ItemWriter<Users> {
    @Autowired
    UsersRepository usersRepository;
    @Override
    public void write(Chunk<? extends Users> chunk) throws Exception {
        System.out.println(chunk.getItems());
        usersRepository.saveAll(chunk.getItems());
       usersRepository.findAll().forEach(System.out::println);
    }
}
