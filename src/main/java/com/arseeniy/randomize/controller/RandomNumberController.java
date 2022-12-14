package com.arseeniy.randomize.controller;

import com.arseeniy.randomize.common.RandomNumber;
import com.arseeniy.randomize.common.RequestHistoryEntity;
import com.arseeniy.randomize.service.RandomNumberService;
import com.arseeniy.randomize.service.RequestHistoryService;
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
    private RequestHistoryService requestHistoryService;

    @GetMapping("/get/random/{min}/{max}/{name}")
    public ResponseEntity getRandomNumber(@PathVariable Integer min, @PathVariable Integer max,
                                          @PathVariable String name) {
        if (min < 0) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Your " + min + " - value is negative. " +
                    "Please, try once again.");
        }
        RandomNumber randomNumber = randomNumberService.getRandomNumber(min, max);
        requestHistoryService.addUser(min, max, name, randomNumber);
        return ResponseEntity.status(HttpStatus.OK).body(randomNumber);
    }
}
