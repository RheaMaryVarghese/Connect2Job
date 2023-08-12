package com.example.connect2job;

public class OpportunitiesModel {
    private String Company,Job_Role;

    public OpportunitiesModel(String Company, String Job_Role) {
        this.Company = Company;
        this.Job_Role = Job_Role;
    }

    public String getCompany() {
        return Company;
    }

    public String getJob_Role() {
        return Job_Role;
    }
}
