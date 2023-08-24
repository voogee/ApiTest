package com.voogee.test;

import com.voogee.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestJdbc {

    @Resource
    DataSource dataSource;
    //用于访问数据库的组件
    @Resource
    JdbcTemplate jdbcTemplate;

    @Test
    void select1() throws SQLException {
        String sql = "SELECT count(*) from `users`";
        Integer i = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("user 表中共有" + i + "条数据。");
    }
    //只能查一条
    @Test
    public void  select2(){
        String sql = "SELECT * from `users` where id =?";
        Map<String,Object> a = jdbcTemplate.queryForMap(sql,1);
        System.out.println(a);
    }

    //返回一个List集合
    @Test
    public void  select3(){
        String sql = "SELECT * from `users`";
        List<Map<String,Object>> a = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> i :a){
            System.out.println(i);
        }
    }
    //返回一行的某一列值
    @Test
    public void  select4(){
        String sql = "SELECT username from `users` where  id =1";
        String a = jdbcTemplate.queryForObject(sql,  String.class);
        System.out.println(a);
    }

    //返回一行的所有值
    @Test
    public void  select5(){
        String sql = "SELECT * from `users` where  id =1";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User a = jdbcTemplate.queryForObject(sql, rowMapper);
        System.out.println(a);
    }


  //update
    @Test
    public void update(){
        String sql = "update users set password='user2pass' where id = ? and username = ?";
        int i = jdbcTemplate.update(sql, 2,"user2");//指定参数，不需要双引号
        System.out.println(i);
    }
    //insert
    @Test
    public void insert(){
        String sql = "INSERT INTO `db_test`.`users` (`id`, `username`, `password`, `email`, `reg_date`) VALUES (2, 'user2', '1234', 'user2@so.com', '2023-08-01 03:34:02');";
        int i = jdbcTemplate.update(sql, 2,"user2");//指定参数，不需要双引号
        System.out.println(i);
    }


}


