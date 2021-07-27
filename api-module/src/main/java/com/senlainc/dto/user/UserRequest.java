package com.senlainc.dto.user;

import com.senlainc.entity.User;

import javax.validation.constraints.*;

public class UserRequest {

    @NotNull
    @NotBlank(message = "FirstName cannot be blank")
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Max(value = 7, message = "Gender should not be greater than 7")
    private String gender;
    @NotNull
    private String username;
    @NotNull
    @Min(value = 10, message = "Password should not be less than 10")
    private String password;
    @Email(message = "Email should be valid")
    private String email;
    @NotNull
    @NotBlank(message = "City cannot be blank")
    private String city;

    public UserRequest(){
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
