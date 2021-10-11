package com.example.musicsec.model.binding;

import com.example.musicsec.model.validators.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch(first = "password",
        second = "confirmPassword")
public class UserRegisterBindingModel {
    @Size(min = 3, max = 42,message = "My error message")
    @NotEmpty
    private String username;
    @Email
    private String email;
    @Size(min = 3, max = 42)
    @NotEmpty
    private String fullname;
    @Size(min = 2, max = 42)
    private String password;
    private String confirmPassword;

    public String getUsername () {
        return username;
    }

    public UserRegisterBindingModel setUsername (String username) {
        this.username = username;
        return this;
    }

    public String getEmail () {
        return email;
    }

    public UserRegisterBindingModel setEmail (String email) {
        this.email = email;
        return this;
    }

    public String getFullname () {
        return fullname;
    }

    public UserRegisterBindingModel setFullname (String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getPassword () {
        return password;
    }

    public UserRegisterBindingModel setPassword (String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword () {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword (String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
