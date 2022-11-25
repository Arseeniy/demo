package com.arseeniy.randomize.controller;

import com.arseeniy.randomize.common.RandomNumber;
import com.arseeniy.randomize.common.RequestHistoryEntity;
import com.arseeniy.randomize.service.RandomNumberServiceImpl;
import com.arseeniy.randomize.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class RandomNumberController {
    @Autowired
    private RandomNumberServiceImpl randomNumberServiceImpl;
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/get/random/{min}/{max}/{name}")
    public ResponseEntity getRandomNumber(@PathVariable Integer min, @PathVariable Integer max,
                                                        @PathVariable String name) {
        if (min < 0) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("\"min\" - value is negative.");
        }
        RequestHistoryEntity currentRequestHistoryEntity = new RequestHistoryEntity();
        currentRequestHistoryEntity.setMin(min);
        currentRequestHistoryEntity.setMax(max);
        currentRequestHistoryEntity.setName(name);
        currentRequestHistoryEntity.setDate(new Date());
        userService.addUser(currentRequestHistoryEntity);
        return ResponseEntity.status(HttpStatus.OK).body(randomNumberServiceImpl.getRandomNumber(min, max));
    }
}
