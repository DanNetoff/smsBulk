package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionToMDB {
    static final  String DB_URL = "jdbc:ucanaccess://C:\\lo.mdb";
    static final String JDBC_DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = null;
        connection = DriverManager.getConnection(DB_URL,"admin","777");
        return connection;
    }
}
