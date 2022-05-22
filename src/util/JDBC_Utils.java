package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_Utils {

    private static DataSource ds;

    static {

        try {
            Properties pro = new Properties();
            pro.load(JDBC_Utils.class.getClassLoader().getResourceAsStream("druid.properties"));

            ds = (DataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    @SuppressWarnings("all")
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
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

    @SuppressWarnings("all")
    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }

    /**
     * 获取连接池方法
     */
    public static DataSource getDataSource() {
        return ds;
    }


}