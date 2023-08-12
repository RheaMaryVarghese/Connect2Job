package com.example.connect2job;

public class View_ApplicationsModel {

    private String Name,Username;

    public View_ApplicationsModel(String Name, String Username) {
        this.Name = Name;
        this.Username = Username;
    }

    public String getName() {
        return Name;
    }

    public String getJUsername() {
        return Username;
    }
}
