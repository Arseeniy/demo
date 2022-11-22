package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Component
public class MyService {
    @Autowired
    private Integer min;
    private Integer max;

    public String getZoo() {
        List<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        return animals.toString();
    }

    public RandomNumber getRandomNumber() {
        return new RandomNumber(min, max, ThreadLocalRandom.current().nextInt(min, max));
    }
}
