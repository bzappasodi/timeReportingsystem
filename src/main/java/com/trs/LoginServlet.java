package com.trs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LoginServlet.java - a class for controlling the login and register user
 * deleting from an Oracle DB.
 *
 * @author Bill Zappasodi
 * @version 1.0
 * @see LogoutServlet
 */
public class LoginServlet extends HttpServlet {
    final static Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    UserBean user;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        user = new UserBean();
        user.setUserName(request.getParameter("un"));
        user.setPassword(request.getParameter("pw"));
        user.setFirstName(request.getParameter("firstname"));
        user.setLastName(request.getParameter("lastname"));

        if (request.getParameter("type").equals("login")) {
            try {
                user = UserDAO.login(user);
                if (user.isValid()) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser",
                            user.getFirstName());
                    response.sendRedirect("SearchTime.do?type=viewprojects");
                } else {
                    request.setAttribute(
                            "databaseResponse",
                            "No record can be found for user: "
                                    + request.getParameter("un"));
                    getServletConfig().getServletContext()
                            .getRequestDispatcher("/registeruser.jsp")
                            .forward(request, response);
                }
            } catch (Throwable e) {
                logger.warn("No valid user {}");
            }
        } else if (request.getParameter("type").equals("registeruser")) {
            try {
                user = UserDAO.register(user);
                logger.info("user {}", user);
                if (user.isValid()) {
                    user.getFirstName();
                    HttpSession session = request.getSession(true);
                    session.setAttribute("currentSessionUser",
                            user.getFirstName());
                    response.sendRedirect("SearchTime.do?type=viewprojects");
                } else {
                    request.setAttribute("databaseResponse",
                            "The user record was not inserted:");
                    getServletConfig().getServletContext()
                            .getRequestDispatcher("/registeruser.jsp")
                            .forward(request, response);
                }
            } catch (Throwable e) {
                logger.warn("No valid user {}", e);
            }

        }

    }
}
