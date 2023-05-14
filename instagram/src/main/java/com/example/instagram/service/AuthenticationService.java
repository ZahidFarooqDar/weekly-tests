package com.example.instagram.service;

import com.example.instagram.model.AuthenticationToken;
import com.example.instagram.model.User;
import com.example.instagram.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    ITokenRepo iTokenRepo;

    public AuthenticationToken getToken(User user) {

        return  iTokenRepo.findByUser(user);

    }

    public void saveToken(AuthenticationToken token) {
        iTokenRepo.save(token);
    }
    public boolean authenticate(String email,String token){
        AuthenticationToken authenticationToken = iTokenRepo.findFirstByToken(token);
        Optional<String> expectedMail = Optional.ofNullable(authenticationToken.getUser().getEmail());
        if(expectedMail.isPresent()){
            return true;
        }else
            return false;
    }
}
