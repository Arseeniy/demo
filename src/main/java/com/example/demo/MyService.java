package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MyService {

    public String getZoo() {
        List<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        return animals.toString();
    }

    public ResponseEntity<RandomNumber> getRandomNumber(Integer min, Integer max) {
        if (min < 0) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        RandomNumber number = new RandomNumber(min, max, ThreadLocalRandom.current().nextInt(min, max));
        return new ResponseEntity<>(number, HttpStatus.OK);
    }
}
