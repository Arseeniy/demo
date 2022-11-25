package com.arseeniy.randomize.controller;

import com.arseeniy.randomize.common.RandomNumber;
import com.arseeniy.randomize.common.RequestHistoryEntity;
import com.arseeniy.randomize.service.RandomNumberService;
import com.arseeniy.randomize.service.UserService;
import com.arseeniy.randomize.service.impl.RandomNumberServiceImpl;
import com.arseeniy.randomize.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class RandomNumberController {
    @Autowired
    private RandomNumberService randomNumberService;
    @Autowired
    private UserService userService;

    @GetMapping("/get/random/{min}/{max}/{name}")
    public ResponseEntity getRandomNumber(@PathVariable Integer min, @PathVariable Integer max,
                                                        @PathVariable String name) {
        if (min < 0) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Your \"min\" - value is negative. " +
                    "Please, try once again.");
        }
        RequestHistoryEntity currentRequestHistoryEntity = new RequestHistoryEntity();
        RandomNumber randomNumber = randomNumberService.getRandomNumber(min,max);
        currentRequestHistoryEntity.setMin(min);
        currentRequestHistoryEntity.setMax(max);
        currentRequestHistoryEntity.setName(name);
        currentRequestHistoryEntity.setDate(new Date());
        currentRequestHistoryEntity.setResult(randomNumber.getResult());
        userService.addUser(currentRequestHistoryEntity);

        return ResponseEntity.status(HttpStatus.OK).body(randomNumber);
    }
}
