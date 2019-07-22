package com.wangming.springstransaction.dao;

import com.wangming.springstransaction.SingleThreadConnectionHolder;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: ming.wang
 * @Date: 2019/7/18 11:27
 * @Description: 扣减库存
 */
@Slf4j
public class DeductionStockDao {
    private DataSource dataSource;

    public DeductionStockDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void deduction() throws SQLException {
        Connection connection = SingleThreadConnectionHolder.getConnection(dataSource);
//        log.info("执行业务逻辑....扣减库存成功");
        log.info("扣减库存成功线程: {},使用管道(hashcode): {}", Thread.currentThread().getName(), connection.hashCode());
    }
}
