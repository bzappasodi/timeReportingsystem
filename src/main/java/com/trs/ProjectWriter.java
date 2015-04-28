package com.trs;

/**
 * Created by Zapp on 4/24/2015.
 */
public interface ProjectWriter {
    boolean addProject(Project p);

    boolean updateProject(Project p);

    boolean addClient(Project p);

    boolean deleteProject(Project p);

    boolean addTask(Project p);
}