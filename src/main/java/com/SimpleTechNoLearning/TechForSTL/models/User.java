package com.SimpleTechNoLearning.TechForSTL.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends AbstractEntity{

   @NotNull
//   @Size(min=6, max=16, message = "character must be between 6 to 16")
    private String username;
    @NotNull
//    @Size(min=6, max=16, message = "character must be between 6 to 16")
//    private String email;
    @NotNull
    private String pwHash;
//    @Transient
//    private String verifyPassword;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

//    public User(String username, String email, String password, String verifyPassword) {
//        this.username = username;
//        this.email=email;
//        this.pwHash = encoder.encode(password);
//        this.verifyPassword=verifyPassword;
//    }

    public String getUsername() {
        return username;
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

//    public String getPwHash() {
//        return pwHash;
//    }

//    public void setPwHash(String pwHash) {
//        this.pwHash = pwHash;
//    }

//    public String getVerifyPassword() {
//        return verifyPassword;
//    }
//
//    public void setVerifyPassword(String verifyPassword) {
//        this.verifyPassword = verifyPassword;
//    }

    public boolean isMatchingPassword(String password) {
        String candidateHash = encoder.encode(password);
        return candidateHash.equals(pwHash);
    }

}
