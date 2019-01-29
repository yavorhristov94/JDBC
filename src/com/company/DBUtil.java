package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static final String oraUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
    static final String oraUser = "fubar";
    static final String oraPass = "fubar";

    static final String sqlUrl = "jdbc:mysql://localhost:3306/world";
    static final String sqlUser = "root";
    static final String sqlPass = "root";

    public static Connection getConnection (DBType dbType) throws SQLException {
        Connection conn;
        switch (dbType) {
            case ORADB:
                conn = DriverManager.getConnection(oraUrl,oraUser,oraPass);
                return conn;

            case MYSQLDB:
                conn = DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
                return conn;
            default:
                return null;
        }

    }
}
