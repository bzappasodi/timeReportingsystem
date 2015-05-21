package com.trs;

/**
 * Created by Zapp on 4/24/2015.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LogoutServlet.java - a class for controlling user logout deleting from an
 * Oracle DB.
 *
 * @author Bill Zappasodi
 * @version 1.0
 * @see LoginServlet
 */
public class LogoutServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
        HttpSession session = request.getSession(true);
        session.invalidate();
        response.sendRedirect("index.jsp"); // logged-in page

    }


}
