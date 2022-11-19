package com.example.demo;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@org.springframework.stereotype.Controller
public class Controller {

    private final MyService service = new MyService();

    @GetMapping("/get/zoo")
    @ResponseBody
    public String getZoo() {
        return service.getZoo();
    }

    @GetMapping("/get/random/{min}/{max}")
    @ResponseBody
    public ResponseEntity<RandomNumber> getRandomNumber(@PathVariable Integer min, @PathVariable Integer max) {
        return service.getRandomNumber(min, max);
    }
}
