package com.trs;

/**
 * Created by Zapp on 4/24/2015.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * SearchTime.java - a class for controlling the selecting from an Oracle DB.
 *
 * @author Bill Zappasodi
 * @version 1.0
 * @see SearchTime
 * @see ProjectDB
 */
public class SearchTime extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static ProjectDAO ProjectDAO = null;
    final static Logger logger = LoggerFactory.getLogger(SearchTime.class);
    boolean foundIt = false;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        Project project = new Project();
        ProjectDAO = DAOFactory.getProjectDAO();
        String projectId = request.getParameter("projectId");
        project.setProjectId(projectId);

        if (request.getParameter("type").equals("viewprojects")) {
            HttpSession session = request.getSession();

            if (session.getAttribute("projects") == null) {
                ArrayList<Project> projects = ProjectDAO.getProjects();
                session.setAttribute("projects", projects);
                foundIt = true;
                logger.info("Found it {}", foundIt);
            }
            if (foundIt) {
                getServletConfig().getServletContext()
                        .getRequestDispatcher("/view.jsp")
                        .forward(request, response);
                session.removeAttribute("projects");
            } else {
                logger.info("No project matches that code {}.  Found it {}", projectId, foundIt);
            }
        }

        if (request.getParameter("type").equals("viewtasks")) {
            HttpSession session = request.getSession();
            foundIt = false;

            if (session.getAttribute("tasks") == null) {
                ArrayList<Project> tasks = ProjectDAO.selectProject(projectId);
                session.setAttribute("tasks", tasks);
                foundIt = true;
            }

            if (foundIt) {
                getServletConfig().getServletContext()
                        .getRequestDispatcher("/viewTasks.jsp")
                        .forward(request, response);
                session.removeAttribute("tasks");
            } else {
                logger.info("No tasks found {} ", foundIt);

            }

        } else if (request.getParameter("type").equals("addtasks")) {
            Project p = ProjectDAO.getTasks(projectId);
            foundIt = false;
            System.out.println();
            if (p != null) {
                foundIt = true;
            }

            if (foundIt) {
                request.setAttribute("description", p.getDescription());
                request.setAttribute("projectId", p.getProjectId());
                getServletConfig().getServletContext()
                        .getRequestDispatcher("/addhours.jsp")
                        .forward(request, response);

            } else {
                logger.info("No project matches {} ", foundIt);
            }

        } else if (request.getParameter("type").equals("edit")) {
            Project p = ProjectDAO.getTasks(projectId);
            foundIt = false;
            System.out.println();
            if (p != null) {
                foundIt = true;
            }

            if (foundIt) {
                request.setAttribute("description", p.getDescription());
                request.setAttribute("startdate", p.getStartdate());
                request.setAttribute("duedate", p.getDuedate());
                request.setAttribute("hours", p.getHours());
                request.setAttribute("invoicesent", p.getInvoicesent());
                request.setAttribute("projectId", p.getProjectId());
                getServletConfig().getServletContext()
                        .getRequestDispatcher("/update.jsp")
                        .forward(request, response);

            } else {
                logger.info("No projects found {}", foundIt);
            }

        } else if (request.getParameter("type").equals("insertprojects")) {
            HttpSession session = request.getSession();
            foundIt = false;
            if (session.getAttribute("clients") == null) {
                ArrayList<Project> clients = ProjectDAO.getClients();
                session.setAttribute("clients", clients);
                foundIt = true;
            }
            if (foundIt) {
                getServletConfig().getServletContext()
                        .getRequestDispatcher("/enter.jsp")
                        .forward(request, response);
                session.removeAttribute("clients");

            } else {
                logger.info("No project matches that code {}", foundIt);

            }
        }
    }

}
