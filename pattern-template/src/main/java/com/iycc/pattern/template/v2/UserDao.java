package com.iycc.pattern.template.v2;

import com.iycc.pattern.template.entity.User;

import java.sql.ResultSet;
import java.util.List;

/**
 * 版本2：JdbcTemplate作为变量注入进来，实现解耦合
 * Created by iycc on 2018/3/12.
 */
public class UserDao {
    private JdbcTemplate JdbcTemplate = new JdbcTemplate();

    public List<?> query(){
        String sql = "select * from t_user";
        return JdbcTemplate.executeQuery(sql,new RowMapper<User>(){
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws Exception {
                User user = new User();
                user.setId(rs.getInt("userId"));
                user.setName(rs.getString("name"));
                return user;
            }
        },null);
    }

}
