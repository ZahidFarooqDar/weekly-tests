package com.example.instagram.service;

import com.example.instagram.dao.SignInInput;
import com.example.instagram.dao.SignInOutput;
import com.example.instagram.dao.SignUpInput;
import com.example.instagram.dao.SignUpOutput;
import com.example.instagram.model.AuthenticationToken;
import com.example.instagram.model.User;
import com.example.instagram.repository.IUserRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    AuthenticationService tokenService;

    public SignInOutput signIn(SignInInput signInDto) {

        //get email

        User user = userRepository.findFirstByEmail(signInDto.getEmail());

        if (user == null) {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //encrypt the password

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getPassword());

        if (!isPasswordValid) {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //figure out the token

        AuthenticationToken authToken = tokenService.getToken(user);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!", authToken.getToken());
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;

    }

    public SignUpOutput signUp(SignUpInput signUpDto) {

        User user = userRepository.findFirstByEmail(signUpDto.getEmail());

        if (user != null) {
            throw new IllegalStateException("User already exists!!!!...sign in instead");
        }


        //encryption
        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //save the user

        user = new User(signUpDto.getFirstName(),
                signUpDto.getLastName(), signUpDto.getAge(), signUpDto.getEmail(),
                encryptedPassword, signUpDto.getPhoneNumber());

        userRepository.save(user);

        //token creation and saving

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        return new SignUpOutput("User registered", "User created successfully");

    }

    public void updateUser(SignUpInput signUpInput) {
        User user1 = userRepository.findFirstByEmail(signUpInput.getEmail());
        if(user1 == null){
            throw new IllegalStateException("User invalid..!!!");
        }
        String encryptedPassword = null;
        if(signUpInput.getEmail() != null)
        {
            try {
                encryptedPassword = encryptPassword(signUpInput.getPassword());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        //save the user
        User user = new User(user1.getId(),signUpInput.getFirstName(),signUpInput.getLastName(),signUpInput.getAge(),signUpInput.getEmail(),encryptedPassword,signUpInput.getPhoneNumber());

        userRepository.save(user);
    }
}


