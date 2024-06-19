package com.SimpleTechNoLearning.TechForSTL.models;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;

@Entity
public class UserProfile extends AbstractEntity{

    @NotNull
    @NotBlank
    private String first_Name;
    @NotNull
    @NotBlank
    private String last_Name;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Size(min = 10, max = 12, message = "valid phone number" )
    private String phone_Number;
    @NotNull
    @NotBlank
    @Size(min=2,max = 16)
    private String State;


    public UserProfile() {}


    public UserProfile(String first_Name, String last_Name, String email, String phone_Number, String State) {
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.email = email;
        this.phone_Number = phone_Number;
        this.State = State;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_Number() {

        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {

        this.phone_Number = phone_Number;
    }

    public String getState() {

        return State;
    }

    public void setState(String state) {
        State = state;
    }
    public String getDesignation() {
        return State;
    }

}
