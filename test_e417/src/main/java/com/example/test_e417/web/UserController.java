package com.example.test_e417.web;

import com.example.test_e417.domain.User;
import com.example.test_e417.services.MapValidationErrorService;
import com.example.test_e417.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public ResponseEntity<?> register (@Valid @RequestBody User user,
                                       BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        User newUser = userService.saveUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
