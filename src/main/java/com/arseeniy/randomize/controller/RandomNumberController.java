package com.arseeniy.randomize.controller;

import com.arseeniy.randomize.common.RandomNumber;
import com.arseeniy.randomize.service.RandomNumberService;
import com.arseeniy.randomize.service.RequestHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class RandomNumberController {
    private String conflict = "456789";
    @Autowired
    private RandomNumberService randomNumberService;
    @Autowired
    private RequestHistoryService requestHistoryService;
    //КОНФЛИКТ 123123
    //КОНФЛИКТ 123123
    private String changeConflictVar(String tmp){
        return this.conflict=tmp;
    }

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
