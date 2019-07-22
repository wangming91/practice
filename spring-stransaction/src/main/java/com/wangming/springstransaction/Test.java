package com.wangming.springstransaction;

import com.wangming.springstransaction.service.OrderService;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * @Author: ming.wang
 * @Date: 2019/7/18 14:02
 * @Description:
 */
public class Test {

    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/test?useSSL=false";
    public static final String username = "root";
    public static final String password = "mysql";

    public static void main(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driver);
        basicDataSource.setUrl(jdbcUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        final OrderService orderService = new OrderService(basicDataSource);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> orderService.action(),"name"+i).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
