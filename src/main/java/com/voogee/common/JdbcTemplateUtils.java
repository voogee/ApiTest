package com.voogee.common;

import com.voogee.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateUtils{

    @Resource
    DataSource dataSource;
    //用于访问数据库的组件
    @Resource
    JdbcTemplate jdbcTemplate;

    //查询记录数
    public  Integer SelectCount(String sql) throws SQLException {
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
        return count;
    }

    // 只能查一条
    public Map<String,Object> SelectOne(String sql) throws SQLException {
        Map<String,Object> mapdata = jdbcTemplate.queryForMap(sql);
        return mapdata;
    }

    //返回一个List集合
    public List<Map<String, Object>> SelectAll(String sql) throws SQLException {
        List<Map<String, Object>> listdata = jdbcTemplate.queryForList(sql);
        return listdata;
    }

//    //返回一行的某一列值
//    public void  select4(){
//        String sql = "SELECT username from `users` where  id =1";
//        String a = jdbcTemplate.queryForObject(sql,  String.class);
//        System.out.println(a);
//    }
//
//    //返回一行的所有值
//    @Test
//    public void  select5(){
//        String sql = "SELECT * from `users` where  id =1";
//        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
//        User a = jdbcTemplate.queryForObject(sql, rowMapper);
//        System.out.println(a);
//    }


//    //update
//    public void update(){
//        String sql = "update users set password='user2pass' where id = ? and username = ?";
//        int i = jdbcTemplate.update(sql, 2,"user2");//指定参数，不需要双引号
//        System.out.println(i);
//    }
//    //insert
//    public void insert(){
//        String sql = "INSERT INTO `db_test`.`users` (`id`, `username`, `password`, `email`, `reg_date`) VALUES (2, 'user2', '1234', 'user2@so.com', '2023-08-01 03:34:02');";
//        int i = jdbcTemplate.update(sql, 2,"user2");//指定参数，不需要双引号
//        System.out.println(i);
//    }


}
