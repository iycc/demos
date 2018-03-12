package com.iycc.pattern.template.v1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iycc on 2018/3/12.
 */
public abstract class JdbcTemplate {
    protected List<?> executeQuery(String sql, Object[] params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object> result = new ArrayList<Object>();
        try {
            conn = this.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Object obj = rowMapper(rs);
                result.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(rs, ps, conn);
        }
        return result;
    }

    private void close(ResultSet rs, PreparedStatement ps, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection getConnection() {
        Connection conn = null;
        String driverName = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@192.168.1.150:1521:XE";
        String user = "hr";
        String password = "123456";
        try {
            // 加载驱动
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);
            // 开始连接数据库
            System.out.println("数据库连接成功..");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    protected abstract Object rowMapper(ResultSet rs) throws SQLException;
}
