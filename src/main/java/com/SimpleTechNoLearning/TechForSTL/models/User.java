package com.SimpleTechNoLearning.TechForSTL.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends AbstractEntity{

   @NotNull
    private String username;
    @NotNull
   // @Email
//    private String email;
    @NotNull
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {

        return username;
    }


    public boolean isMatchingPassword(String password) {

        return encoder.matches(password, pwHash);
    }
//    public boolean isMatchingPassword(String password) {
//        String candidateHash = encoder.encode(password);
//        return candidateHash.equals(pwHash);
//    }

}

