package com.example.test_e417.services;

import com.example.test_e417.domain.User;
import com.example.test_e417.exceptions.UsernameAlreadyExistException;
import com.example.test_e417.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User newUser){
        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            newUser.setPassword(newUser.getPassword());
            return userRepository.save(newUser);
        }catch (Exception e){
            throw new UsernameAlreadyExistException("Username '"
                    + newUser.getUsername()
                    + "' is already exist");
        }

    }
}
