package com.wangming.springstransaction.dao;

import com.wangming.springstransaction.SingleThreadConnectionHolder;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: ming.wang
 * @Date: 2019/7/18 11:06
 * @Description:
 */
@Slf4j
public class UserAccountDao {
    private DataSource dataSource;

    public UserAccountDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void buy() throws SQLException {
        Connection connection = SingleThreadConnectionHolder.getConnection(dataSource);
//        log.info("执行业务逻辑.....下单成功");
        log.info("下单成功线程: {},使用管道(hashcode): {}", Thread.currentThread().getName(), connection.hashCode());
    }
}
