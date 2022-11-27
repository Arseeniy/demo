package com.arseeniy.randomize.service.impl;

import com.arseeniy.randomize.common.RandomNumber;
import com.arseeniy.randomize.service.RandomNumberService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomNumberServiceImpl implements RandomNumberService {
    public RandomNumber getRandomNumber(int min, int max) {
        return new RandomNumber(min, max, new Random().nextInt((max - min) + 1) + min);
    }
}
