//package com.SimpleTechNoLearning.TechForSTL.models.dto;
//
//
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;
//
//public class LoginFormDTO {
//
//    @NotNull
//    @NotBlank( message = "username is required")
//    @Size(min = 3, max = 20, message = "Invalid username. Must be between 5 and 20 characters.")
//    private String username;
//
//    @NotNull
//    @NotBlank(message = "Password is required")
//    @Size(min = 6, max = 30, message = "Invalid password. Must be between 6 and 30 characters.")
//
////    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,30}$", message = "Invalid password. Password requires at least one uppercase letter, one lowercase, and a digit (6-30 characters)")
//    private String password;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//}

package com.SimpleTechNoLearning.TechForSTL.models.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull
    @NotBlank
    @Size(min = 5, max = 20, message = "Invalid username. Must be between 5 and 20 characters.")
    private String username;

    @NotNull(message = "Required field")
    @NotBlank
    @Size(min = 6, max = 30, message = "Invalid password. Must be between 6 and 30 characters.")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}