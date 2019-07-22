package com.wangming.springstransaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: ming.wang
 * @Date: 2019/7/18 10:53
 * @Description:
 */
public class TransactionManager {
    private DataSource dataSource;

    public TransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getConnection(DataSource dataSource) throws SQLException {

        return SingleThreadConnectionHolder.getConnection(dataSource);

    }

    //开启事务
    public void start() throws SQLException {
        Connection connection = getConnection(dataSource);
        connection.setAutoCommit(false);
    }

    //回滚事务
    public void rollback() {
        Connection connection = null;
        try {
            connection = getConnection(dataSource);
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭事务
    public void close() throws SQLException {
        Connection connection = getConnection(dataSource);
        connection.setAutoCommit(false);
        connection.close();
    }
}
