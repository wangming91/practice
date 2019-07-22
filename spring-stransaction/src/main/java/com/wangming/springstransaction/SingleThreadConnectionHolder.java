package com.wangming.springstransaction;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: ming.wang
 * @Date: 2019/7/18 10:49
 * @Description:
 */
public class SingleThreadConnectionHolder {
    private static ThreadLocal<ConectionHolder> threadLocal = new ThreadLocal<>();

    private static ConectionHolder getConnectionHolder() {

        ConectionHolder conectionHolder = threadLocal.get();
        if (null == conectionHolder) {
            conectionHolder = new ConectionHolder();

            threadLocal.set(conectionHolder);
        }
        return conectionHolder;
    }

    public static Connection getConnection(DataSource dataSource) throws SQLException {

        return getConnectionHolder().getConnectionByDataSource(dataSource);

    }
}
