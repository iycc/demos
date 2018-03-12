package com.iycc.pattern.template.v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iycc on 2018/3/12.
 */
public class JdbcTemplate {
    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object> result = new ArrayList<Object>();
        try {
            conn = this.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                ps.setObject(i + 1, values[i]);
            }
            rs = ps.executeQuery();
            int rowNum = 1;
            while (rs.next()) {
                result.add(rowMapper.mapRow(rs, rowNum++));
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
        // TODO 参照 v1 的写法
        return null;
    }
}
