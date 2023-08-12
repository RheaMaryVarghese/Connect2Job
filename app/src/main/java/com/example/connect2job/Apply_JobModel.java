package com.example.connect2job;

public class Apply_JobModel {
    private String Name,Username,Company,Job_Role;

    public Apply_JobModel(String Name, String Username,String Company,String Job_Role) {
        this.Name = Name;
        this.Username = Username;
        this.Company = Company;
        this.Job_Role = Job_Role;

    }

    public String getCompany() {
        return Company;
    }

    public String getJob_Role() {
        return Job_Role;
    }

    public String getName() {
        return Name;
    }

    public String getUsername() {
        return Username;
    }


}
