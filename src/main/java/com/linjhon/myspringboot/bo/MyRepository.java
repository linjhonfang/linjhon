package com.linjhon.myspringboot.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class MyRepository {
    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public MyRepository(DataSource dataSource,JdbcTemplate jdbcTemplate){
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

}
