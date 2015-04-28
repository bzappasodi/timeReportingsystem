package com.trs;

/**
 * Created by Zapp on 4/24/2015.
 */
import java.util.ArrayList;

public interface ProjectReader {

    Project getTasks(String client);

    ArrayList<Project> getClients();

    ArrayList<Project> getProjects();

    ArrayList<Project> selectProject(String client);

}