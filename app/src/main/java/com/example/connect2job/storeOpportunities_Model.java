package com.example.connect2job;

public class storeOpportunities_Model {

    private String Company,Job_Role,Desc;

    public storeOpportunities_Model(String Company, String Job_Role,String Desc) {
        this.Company = Company;
        this.Job_Role = Job_Role;
        this.Desc=Desc;
    }

    public String getCompany() {
        return Company;
    }

    public String getJob_Role() {
        return Job_Role;
    }

    public String getDesc() {
        return Desc;
    }
}
