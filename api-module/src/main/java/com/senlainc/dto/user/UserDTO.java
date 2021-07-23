package com.senlainc.dto.user;

import com.senlainc.entity.User;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String gender;
    private String username;
    private String password;
    private String email;
    private String city;

    public UserDTO(){
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User convertToUserEntity(){
        return new User(getFirstName(), getLastName(), getGender(), getCity(), getEmail(), getUsername(), getPassword());
    }
}
