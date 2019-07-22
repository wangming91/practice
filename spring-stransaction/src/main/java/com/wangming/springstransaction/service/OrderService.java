package com.wangming.springstransaction.service;

import com.wangming.springstransaction.TransactionManager;
import com.wangming.springstransaction.dao.DeductionStockDao;
import com.wangming.springstransaction.dao.UserAccountDao;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author: ming.wang
 * @Date: 2019/7/18 11:29
 * @Description:
 */
public class OrderService {
    private DeductionStockDao deductionStockDao;
    private UserAccountDao userAccountDao;
    private TransactionManager transactionManager;

    public OrderService(DataSource dataSource) {
        this.deductionStockDao = new DeductionStockDao(dataSource);
        this.userAccountDao = new UserAccountDao(dataSource);
        this.transactionManager = new TransactionManager(dataSource);
    }

    public void action() {
        try {
            transactionManager.start();
            userAccountDao.buy();
            deductionStockDao.deduction();
            transactionManager.close();
        } catch (SQLException e) {
            transactionManager.rollback();
            e.printStackTrace();
        }


    }
}
