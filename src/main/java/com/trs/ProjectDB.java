package com.trs;

/**
 * Created by Zapp on 4/24/2015.
 */

import java.util.*;
import java.sql.*;

/**
 * ProductDB.java - a class for updating, selecting, and deleting from an Oracle
 * DB.
 *
 * @author Bill Zappasodi
 * @version 1.0
 * @see SearchTime
 *
 * @see SubmitTime
 */
public class ProjectDB implements ProjectDAO {

    private Connection connection = null;

    public ArrayList<Project> getProjects() {
        try {
            ArrayList<Project> projects = new ArrayList<Project>();

            String query = "SELECT \"CLIENTS\".\"NAME\" as \"CLIENT\", "
                    + "\"PROJECTS\".\"DESCRIPTION\", "
                    + "\"PROJECTS\".\"HOURS\", "
                    + "\"PROJECTS\".\"STARTDATE\", "
                    + "\"PROJECTS\".\"DUEDATE\", "
                    + "\"PROJECTS\".\"PROJECT_ID\", "
                    + "\"CLIENTS\".\"CLIENT_ID\", "
                    + "\"PROJECTS\".\"INVOICESENT\", "
                    + "SUM(\"TASKS\".\"HOURS\") as \"TOTAL_HOURS\" "
                    + "FROM \"PROJECTS\",\"CLIENTS\",\"TASKS\" "
                    + "WHERE \"CLIENTS\".\"CLIENT_ID\"=\"PROJECTS\".\"CLIENT\" "
                    + "GROUP BY " + "\"CLIENTS\".\"NAME\", "
                    + "\"PROJECTS\".\"PROJECT_ID\", "
                    + "\"PROJECTS\".\"DESCRIPTION\", "
                    + "\"PROJECTS\".\"HOURS\", "
                    + "\"CLIENTS\".\"CLIENT_ID\", "
                    + "\"PROJECTS\".\"STARTDATE\", "
                    + "\"PROJECTS\".\"DUEDATE\", "
                    + "\"PROJECTS\".\"INVOICESENT\" "
                    + "ORDER BY \"PROJECTS\".\"STARTDATE\" ASC";
            connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String client = rs.getString("CLIENT");
                String description = rs.getString("DESCRIPTION");
                String totalhours = rs.getString("TOTAL_HOURS");
                String projectId = rs.getString("PROJECT_ID");
                String hours = rs.getString("HOURS");
                String startdate = rs.getString("STARTDATE");
                String duedate = rs.getString("DUEDATE");
                String invoicesent = rs.getString("INVOICESENT");
                String clientId = rs.getString("CLIENT_ID");
                Project p = new Project(client, description, projectId,
                        totalhours, startdate, hours, duedate, duedate,
                        invoicesent, clientId);
                projects.add(p);

            }
            rs.close();
            ps.close();
            return projects;
        } catch (SQLException sqle) {
            System.out.println("Exception has occurred! "
                    + sqle);
        }
        return null;
    }

    /**
     * SQL to select all tasks belonging to the project
     *
     *
     * @return tasks the result collection gets passed back to the controller
     */
    public ArrayList<Project> selectProject(String projectId) {

        try {
            ArrayList<Project> tasks = new ArrayList<Project>();

            String query = "SELECT * FROM TASKS where PROJECT_ID = ?";
            connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, projectId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String hours = rs.getString("HOURS");
                String hoursadded = rs.getString("HOURS_ADDED");
                String description = rs.getString("DESCRIPTION");
                Project p = new Project(description, hours, hoursadded,
                        projectId);
                tasks.add(p);
            }
            rs.close();
            ps.close();
            return tasks;
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // for debugging
            return null;
        }
    }

    /**
     * SQL to select all from projects
     *
     *
     *
     */
    public Project getTasks(String projectId) {
        try {

            String selectProject = "select * from PROJECTS where PROJECT_ID = ?";
            connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(selectProject);
            ps.setString(1, projectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String startdate = rs.getString("STARTDATE");
                String invoicesent = rs.getString("INVOICESENT");
                String hours = rs.getString("HOURS");
                String client = "";
                String duedate = rs.getString("DUEDATE");
                String description = rs.getString("DESCRIPTION");
                Project p = new Project(client, description, projectId,
                        duedate, startdate, hours, duedate, duedate,
                        invoicesent, invoicesent);
                rs.close();
                ps.close();
                return p;
            } else {
                return null;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // for debugging
            return null;
        }
    }

    /**
     * SQL to select all clients
     *
     *
     * @return clients. The clients result collection gets passed back to the
     * controller
     */
    public ArrayList<Project> getClients() {
        try {
            ArrayList<Project> clients = new ArrayList<Project>();
            String selectClients = "SELECT NAME, CLIENT_ID FROM CLIENTS";
            connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(selectClients);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String client = rs.getString("NAME");
                String clientId = rs.getString("CLIENT_ID");
                Project p = new Project(client, clientId);
                clients.add(p);
            }
            rs.close();
            ps.close();
            return clients;
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // for debugging
            return null;
        }
    }

    /**
     * SQL to select insert a new project
     *
     *
     */
    public boolean addProject(Project p) {
        try {
            String insert = "INSERT INTO PROJECTS"
                    + "(CLIENT,DESCRIPTION,HOURS,STARTDATE,DUEDATE,INVOICESENT,CLIENT_ID,PROJECT_ID) "
                    + "VALUES(?,?,?,?,?,?,?,PROJECTS_SEQ.NEXTVAL)";
            connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, p.getClientId());
            ps.setString(2, p.getDescription());
            ps.setString(3, p.getHours());
            ps.setString(4, p.getStartdate());
            ps.setString(5, p.getDuedate());
            ps.setString(6, p.getInvoicesent());
            ps.setString(7, p.getClientId());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // for debugging
            return false;
        }
    }

    /**
     * SQL to delete a new project
     *
     *
     */
    public boolean deleteProject(Project p) {
        try {
            String delete = "DELETE FROM PROJECTS WHERE PROJECT_ID = ?";
            connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setString(1, p.getProjectId());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // for debugging
            return false;
        }
    }

    /**
     * SQL to update a project
     *
     *
     */
    public boolean updateProject(Project p) {
        try {
            String update = "UPDATE PROJECTS SET " + "DESCRIPTION = ?, "
                    + "HOURS = ?, " + "STARTDATE = ?, " + "DUEDATE = ?, " + "INVOICESENT = ? "
                    + "WHERE PROJECT_ID = ?";
            connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, p.getDescription());
            ps.setString(2, p.getHours());
            ps.setString(3, p.getStartdate());
            ps.setString(4, p.getDuedate());
            ps.setString(5, p.getInvoicesent());
            ps.setString(6, p.getProjectId());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // for debugging
            return false;
        }
    }

    /**
     * SQL to select insert a new task into a project
     *
     *
     */
    public boolean addTask(Project p) {
        try {
            String update = "INSERT INTO TASKS (PROJECT_ID,HOURS_ADDED,DESCRIPTION,HOURS)  VALUES(?,?,?,?) ";
            connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, p.getProjectId());
            ps.setString(2, p.getHoursadded());
            ps.setString(3, p.getDescription());
            ps.setString(4, p.getHours());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // for debugging
            return false;
        }
    }

    /**
     * SQL to select insert a new client
     *
     *
     */
    public boolean addClient(Project p) {
        try {
            String insert = "INSERT INTO CLIENTS" + "(NAME,ADDRESS,CLIENT_ID) "
                    + "VALUES(?,?,PROJECTS_SEQ.NEXTVAL)";
            connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, p.getName());
            ps.setString(2, p.getAddress());

            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // for debugging
            return false;
        }
    }
}