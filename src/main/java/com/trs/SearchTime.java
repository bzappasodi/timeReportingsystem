package com.trs;

/**
 * Created by Zapp on 4/24/2015.
*/

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
 *
 * @see ProjectDB
 */
public class SearchTime extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static ProjectDAO ProjectDAO = null;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String projectId = request.getParameter("projectId");
        if (request.getParameter("type").equals("viewprojects")) {
            HttpSession session = request.getSession();

            ProjectDAO = DAOFactory.getProjectDAO();
            boolean foundIt = false;
            if (session.getAttribute("projects") == null) {
                ArrayList<Project> projects = ProjectDAO.getProjects();
                session.setAttribute("projects", projects);
                foundIt = true;
            }
            if (foundIt) {
                getServletConfig().getServletContext()
                        .getRequestDispatcher("/view.jsp")
                        .forward(request, response);
                session.removeAttribute("projects");
            } else {
                System.out.println("No project matches that code.\n");
            }
        }

        if (request.getParameter("type").equals("viewtasks")) {
            HttpSession session = request.getSession();
            Project project = new Project();
            project.setProjectId(projectId);
            ProjectDAO = DAOFactory.getProjectDAO();
            boolean foundIt = false;

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
                System.out.println("No tasks found.\n");
            }

        } else if (request.getParameter("type").equals("addtasks")) {

            Project project = new Project();
            project.setProjectId(projectId);
            ProjectDAO = DAOFactory.getProjectDAO();
            Project p = ProjectDAO.getTasks(projectId);
            boolean foundIt = false;
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
                System.out.println("No project matches that code.\n");
            }

        } else if (request.getParameter("type").equals("edit")) {
            Project project = new Project();
            project.setProjectId(projectId);
            ProjectDAO = DAOFactory.getProjectDAO();
            Project p = ProjectDAO.getTasks(projectId);

            boolean foundIt = false;
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
                System.out.println("No project matches that code.\n");
            }

        } else if (request.getParameter("type").equals("insertprojects")) {

            HttpSession session = request.getSession();

            ProjectDAO = DAOFactory.getProjectDAO();
            boolean foundIt = false;
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
                System.out.println("No project matches that code.\n");
            }
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
