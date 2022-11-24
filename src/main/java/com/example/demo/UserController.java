package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

//    @Autowired
//    public UserController(UserServiceImpl service) {
//        this.userServiceImpl = service;
//    }

    @GetMapping("/get/random/{min}/{max}/{name}")
    public ResponseEntity<RandomNumber> getRandomNumber(@PathVariable Integer min, @PathVariable Integer max,
                                                        @PathVariable String name) {
        if (min < 0) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        User currentUser = new User();
        currentUser.setMin(min);
        currentUser.setMax(max);
        currentUser.setName(name);
        currentUser.setDate(new Date());
        userServiceImpl.addUser(currentUser);
        return new ResponseEntity<>(userServiceImpl.getRandomNumber(min, max), HttpStatus.OK);
    }
}
