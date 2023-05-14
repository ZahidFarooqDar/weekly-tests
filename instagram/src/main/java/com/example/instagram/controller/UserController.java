package com.example.instagram.controller;

import com.example.instagram.dao.SignInInput;
import com.example.instagram.dao.SignInOutput;
import com.example.instagram.dao.SignUpInput;
import com.example.instagram.dao.SignUpOutput;
import com.example.instagram.model.User;
import com.example.instagram.service.AuthenticationService;
import com.example.instagram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/signin")
    public SignInOutput signup(@RequestBody SignInInput signInDto)
    {
        return userService.signIn(signInDto);
    }


    @PostMapping("/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signUpDto)
    {
        return userService.signUp(signUpDto);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestParam String email,@RequestParam String token,@RequestBody SignUpInput signUpInput){
        HttpStatus status;
        String message = "";
        if(authenticationService.authenticate(email,token)){
            userService.updateUser(signUpInput);
            message = "Updated Successully";
            status = HttpStatus.ACCEPTED;
        }else{
            message ="Invalid Details to update";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(message,status);

    }

}
