package com.wangming.springstransaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ming.wang
 * @Date: 2019/7/18 10:46
 * @Description:
 */
public class ConectionHolder {
    private Map<DataSource, Connection> map = new HashMap<>();

    public Connection getConnectionByDataSource(DataSource dataSource) throws SQLException {
        Connection connection = map.get(dataSource);

        if (null == connection || connection.isClosed()) {
            connection = dataSource.getConnection();
            map.put(dataSource, connection);
        }
        return connection;
    }
}
