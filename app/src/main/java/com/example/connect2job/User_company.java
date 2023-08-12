package com.example.connect2job;
import java.io.Serializable;

public class User_company implements Serializable{
    private String Name,Specialization,Username,Password;
    private Integer No_of_Employees;


    public User_company(String Name, String Specialization, Integer No_of_Employees,String Username, String Password) {
        this.Name = Name;
        this.Specialization = Specialization;
        this.No_of_Employees = No_of_Employees;
        this.Username=Username;
        this.Password=Password;
    }

    // Add getter and setter methods


    public String getName() {
        return Name;
    }

    public Integer getNo_of_Employees() {
        return No_of_Employees;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }


}
