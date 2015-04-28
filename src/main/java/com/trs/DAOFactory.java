package com.trs;

/**
 * Created by Zapp on 4/24/2015.
 */
public class DAOFactory {
    // this method maps the ProjectDAO interface
    // to the appropriate data storage mechanism
    public static ProjectDAO getProjectDAO() {
        ProjectDAO pDAO = new ProjectDB();
        return pDAO;
    }
}