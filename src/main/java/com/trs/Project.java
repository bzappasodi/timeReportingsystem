package com.trs;


public class Project {

    private String client;
    private String description;
    private String projectId;
    private String clientId;
    private String totalhours;
    private String startdate;
    private String hoursadded;
    private String duedate;
    private String hours;
    private String name;
    private String address;
    private String invoicesent;

    public Project() {
        this("", "", "", "", "", "", "", "", "", "");
    }

    // constructor to get projects and tasks
    public Project(String client, String description, String projectId,
                   String totalhours, String startdate, String hours,
                   String hoursadded, String duedate, String invoicesent,
                   String clientId) {
        this.client = client;
        this.description = description;
        this.projectId = projectId;
        this.clientId = clientId;
        this.hoursadded = hoursadded;
        this.totalhours = totalhours;
        this.startdate = startdate;
        this.duedate = duedate;
        this.hours = hours;
        this.invoicesent = invoicesent;
    }

    // constructor to get clients
    public Project(String client, String clientId) {
        this.client = client;
        this.clientId = clientId;
    }

    // constructor to get tasks
    public Project(String description, String hours, String hoursadded,
                   String projectId) {
        this.description = description;
        this.projectId = projectId;
        this.hoursadded = hoursadded;
        this.hours = hours;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTotalhours(String totalhours) {
        this.totalhours = totalhours;
    }

    public String getTotalhours() {
        return totalhours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getHours() {
        return hours;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setInvoicesent(String invoicesent) {
        this.invoicesent = invoicesent;
    }

    public String getInvoicesent() {
        return invoicesent;
    }

    public void setProjectId(String projectid) {
        this.projectId = projectid;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setClientId(String clientid) {
        this.clientId = clientid;
    }

    public String getClientId() {
        return clientId;
    }

    public void setHoursadded(String hoursadded) {
        this.hoursadded = hoursadded;
    }

    public String getHoursadded() {
        return hoursadded;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}