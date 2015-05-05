package com.trs;

import java.sql.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ConnectionManager.java - a class for the connection pool class for Oracle DB.
 *
 * @author Bill Zappasodi
 * @version 1.0
 * @see SearchTime
 * @see SubmitTime
 */
public class ConnectionManager {
    static Connection con;
    static String url;
    final static Logger logger = LoggerFactory.getLogger(ConnectionManager.class);

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:XE", "trs", "trs");

            } catch (SQLException e) {
                logger.debug("connection failed {}. Exception {} ", con, e);

            }
        } catch (ClassNotFoundException e) {
            logger.debug("driver failed failed {} ", e);
        }
        return con;
    }
}
