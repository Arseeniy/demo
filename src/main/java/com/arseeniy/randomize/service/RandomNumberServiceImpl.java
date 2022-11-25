package com.arseeniy.randomize.service;

import com.arseeniy.randomize.common.RandomNumber;

import java.util.Random;

public class RandomNumberServiceImpl implements RandomNumberService{
    public RandomNumber getRandomNumber(int min, int max) {
        return new RandomNumber(min, max, new Random().nextInt((max-min)+1)+min);
    }
}
