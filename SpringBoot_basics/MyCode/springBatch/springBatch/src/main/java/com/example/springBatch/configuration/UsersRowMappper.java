package com.example.springBatch.configuration;

import com.example.springBatch.data.Users;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRowMappper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users users = new Users();
        users.setId(rs.getInt(1));
        users.setName(rs.getString(2));
        users.setPath(rs.getString(3));
        return users;
    }
}
