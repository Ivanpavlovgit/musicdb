package com.example.musicsec.model.serviceModels;

public class UserRegisterServiceModel {
    private String username;
    private String email;
    private String fullname;
    private String password;


    public String getUsername () {
        return username;
    }

    public UserRegisterServiceModel setUsername (String username) {
        this.username = username;
        return this;
    }

    public String getEmail () {
        return email;
    }

    public UserRegisterServiceModel setEmail (String email) {
        this.email = email;
        return this;
    }

    public String getFullname () {
        return fullname;
    }

    public UserRegisterServiceModel setFullname (String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getPassword () {
        return password;
    }

    public UserRegisterServiceModel setPassword (String password) {
        this.password = password;
        return this;
    }

}
