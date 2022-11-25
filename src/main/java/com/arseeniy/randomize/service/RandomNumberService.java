package com.arseeniy.randomize.service;

import com.arseeniy.randomize.common.RandomNumber;

public interface RandomNumberService {
    public RandomNumber getRandomNumber(int min, int max);
}
