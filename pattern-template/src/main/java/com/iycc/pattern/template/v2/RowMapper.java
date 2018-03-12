package com.iycc.pattern.template.v2;

import java.sql.ResultSet;

/**
 * Created by iycc on 2018/3/12.
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
