package com.trs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SubmitTime.java - a class for controlling the updating, selecting, and
 * deleting from an Oracle DB.
 *
 * @author Bill Zappasodi
 * @version 1.0
 * @see SearchTime
 * @see ProjectDB
 */
public class SubmitTime extends HttpServlet {
    // private static final long serialVersionUID = 1L;
    final static Logger logger = LoggerFactory.getLogger(SubmitTime.class);
    String action = "";
    String projectId = "";
    String message = "";
    String url = "/confirmation.jsp";
    private static ProjectDAO projectDAO = null;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        projectId = request.getParameter("projectId");
        Project project = new Project();
        project.setProjectId(projectId);
        projectDAO = DAOFactory.getProjectDAO();
        if (request.getParameter("type").equals("delete")) {

            boolean success = projectDAO.deleteProject(project);

            if (success) {
                request.setAttribute("databaseResponse",
                        "The database has been updated!!");
                getServletConfig().getServletContext()
                        .getRequestDispatcher("/SearchTime.do?type=viewprojects")
                        .forward(request, response);

            } else {
                request.setAttribute("databaseResponse",
                        "The database has not been updated!!");
                getServletConfig().getServletContext()
                        .getRequestDispatcher("/SearchTime.do?type=viewprojects")
                        .forward(request, response);
            }
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        projectId = request.getParameter("PROJECT_ID");
        String description = request.getParameter("DESCRIPTION");
        String hours = request.getParameter("HOURS");
        String hoursadded = request.getParameter("HOURS_ADDED");
        String startdate = request.getParameter("START_DATE");
        String duedate = request.getParameter("DUE_DATE");
        String clientId = request.getParameter("CLIENT_ID");
        String invoicesent = request.getParameter("INVOICE_SENT");
        String name = request.getParameter("NAME");
        String address = request.getParameter("ADDRESS");

        Project project = new Project();
        project.setProjectId(projectId);
        project.setDescription(description);
        project.setClientId(clientId);
        project.setHours(hours);
        project.setHoursadded(hoursadded);
        project.setStartdate(startdate);
        project.setName(name);
        project.setAddress(address);
        project.setDuedate(duedate);
        project.setInvoicesent(invoicesent);

        projectDAO = DAOFactory.getProjectDAO();

        if (request.getParameter("type").equals("update")) {
            logger.info("type {}", request.getParameter("type"));

            boolean success = projectDAO.updateProject(project);

            if (success) {
                request.setAttribute("databaseResponse",
                        "The project has been updated!!");
                getServletConfig().getServletContext()
                        .getRequestDispatcher(url).forward(request, response);
                logger.info("success {}", success);
            } else {
                request.setAttribute("databaseResponse",
                        "The database has not been updated!!");
                getServletConfig().getServletContext()
                        .getRequestDispatcher(url).forward(request, response);
                logger.info("success fail {}",success);
            }

        } else if (request.getParameter("type").equals("add_hours")) {

            boolean success = projectDAO.addTask(project);
            if (success) {
                request.setAttribute("databaseResponse",
                        "The new task has has been added to the database!!");
                getServletConfig().getServletContext()
                        .getRequestDispatcher(url).forward(request, response);
                logger.info("success ",success);

            } else {
                request.setAttribute("databaseResponse",
                        "The database has not been updated!!");
                getServletConfig().getServletContext()
                        .getRequestDispatcher(url).forward(request, response);
                logger.info("no success ",success);
            }

        } else if (request.getParameter("type").equals("add")) {

            if (description.length() == 0 || hours.length() == 0
                    || startdate.length() == 0 || duedate.length() == 0) {
                message = "Please fill in the missing fields";
                url = "/enter.jsp";
                request.setAttribute("errors", message);
                getServletConfig().getServletContext()
                        .getRequestDispatcher(url).forward(request, response);
            } else {
                boolean success = projectDAO.addProject(project);
                url = "/confirmation.jsp";

                if (success) {
                    request.setAttribute("databaseResponse",
                            "The new project has has been added to the database!!");
                    getServletConfig().getServletContext()
                            .getRequestDispatcher(url)
                            .forward(request, response);
                } else {
                    request.setAttribute("databaseResponse",
                            "The database has not been updated!!");
                    getServletConfig().getServletContext()
                            .getRequestDispatcher(url)
                            .forward(request, response);
                }

            }

        } else if (request.getParameter("type").equals("addnewclient")) {

            if (name.length() == 0 || address.length() == 0) {
                message = "Please fill in the missing fields";
                url = "/addnewclient.jsp";
                request.setAttribute("errors", message);
                getServletConfig().getServletContext()
                        .getRequestDispatcher(url).forward(request, response);
            } else {
                boolean success = projectDAO.addClient(project);
                url = "/confirmation.jsp";

                if (success) {
                    request.setAttribute(
                            "databaseResponse",
                            ""
                                    + name
                                    + " has has been added as a new client to the database!!");
                    getServletConfig().getServletContext()
                            .getRequestDispatcher(url)
                            .forward(request, response);
                } else {
                    request.setAttribute("databaseResponse",
                            "The database has not been updated!!");
                    getServletConfig().getServletContext()
                            .getRequestDispatcher(url)
                            .forward(request, response);
                }

            }

        }

    }
}
