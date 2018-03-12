package com.iycc.pattern.template.v1;

import com.iycc.pattern.template.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 版本1：通过继承JdbcTemplate, 重写rowMapper方法来实现模版方法
 * Created by iycc on 2018/3/12.
 */
public class UserDao extends JdbcTemplate{
    @Override
    protected Object rowMapper(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("userId"));
        user.setName(rs.getString("name"));
        return user;
    }
}
