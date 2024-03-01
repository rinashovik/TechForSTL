//package com.SimpleTechNoLearning.TechForSTL.models.dto;
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//
//public class RegisterFormDTO extends LoginFormDTO {
//
//
////    @Email(message = "Please enter a valid email")
////    @NotNull
////    @NotBlank(message = "Email is required!")
////    private String email;
////
////    public String getEmail() {
////        return email;
////    }
////
////    public void setEmail(String email) {
////        this.email = email;
////    }
//
//    private String verifyPassword;
//
//    public String getVerifyPassword() {
//        return verifyPassword;
//    }
//
//    public void setVerifyPassword(String verifyPassword) {
//        this.verifyPassword = verifyPassword;
//    }
//
//}


package com.SimpleTechNoLearning.TechForSTL.models.dto;

public class RegisterFormDTO extends LoginFormDTO {

    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

}