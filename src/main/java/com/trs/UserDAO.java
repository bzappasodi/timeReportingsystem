package com.trs;

/**
 * Created by Zapp on 4/24/2015.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * UserDAO.java - a class for selecting, and adding users from an Oracle DB.
 *
 * @author Bill Zappasodi
 * @version 1.0
 * @see UserBean
 */
public class UserDAO {
    final static Logger logger = LoggerFactory.getLogger(UserDAO.class);

    static Connection currentCon = null;
    static ResultSet rs = null;

    // method to check if user exists in db
    public static UserBean login(UserBean bean) {

        Statement stmt = null;

        String username = bean.getUsername();
        String password = bean.getPassword();

        String searchQuery = "select * from users where username='" + username
                + "' AND password='" + password + "'";
        try {
            // connect to DB
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user does not exist set the isValid variable to false
            if (!more) {

                bean.setValid(false);
                System.out.println("bean failed");
            } // if user exists set the isValid variable to true
            else if (more) {
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                bean.setFirstName(firstName);
                bean.setLastName(lastName);
                bean.setValid(true);

            }
        } catch (Exception e) {
            logger.debug("Search users exception {}", e);
        }

        return bean;

    }

    // method to add new user to db
    public static UserBean register(UserBean bean) {

        Statement stmt = null;
        String username = bean.getUsername();
        String password = bean.getPassword();
        String firstname = bean.getFirstName();
        String lastname = bean.getLastName();

        String searchQuery = "INSERT INTO USERS"
                + "(FIRSTNAME,LASTNAME,USERNAME,PASSWORD) " + "VALUES('"
                + firstname + "','" + lastname + "','" + username + "','"
                + password + "')";

        try {
            // connect to DB
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = true;
            if (!more) {
                bean.setValid(false);
            } else if (more) {
                bean.setFirstName(firstname);
                bean.setValid(true);
            }
        } catch (Exception e) {

            logger.debug("Creating new user failed: An Exception has occurred! {}", e);
        }

        return bean;
    }
}
