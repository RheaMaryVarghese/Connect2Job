package com.example.connect2job;
import java.io.Serializable;

public class User implements Serializable{
    private String Name,Gender,Email_id,Pic_url,Username,Password,Phone_no,Job_role,Company;
    private Integer Age;


    public User(String Name, Integer Age, String Gender, String Email_id, String Phone_no,String Job_role,String Company,String Username, String Password) {
        this.Name = Name;
        this.Age = Age;
        this.Gender = Gender;
        this.Email_id=Email_id;
        this.Phone_no=Phone_no;
        this.Company=Company;
        this.Job_role=Job_role;
        this.Username=Username;
        this.Password=Password;
    }

    // Add getter and setter methods


    public String getName() {
        return Name;
    }

    public Integer getAge() {
        return Age;
    }

    public String getGender() {
        return Gender;
    }

    public String getEmail_id() {
        return Email_id;
    }

    public String getPhone_no() {
        return Phone_no;
    }

    public String getJob_role() {
        return Job_role;
    }

    public String getCompany() {
        return Company;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }


}