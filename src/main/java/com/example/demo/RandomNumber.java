package com.example.demo;

import java.util.stream.IntStream;

public class RandomNumber {
    int min;
    int max;
    IntStream result;

    public RandomNumber(int min, int max, IntStream result) {
        this.min = min;
        this.max = max;
        this.result = result;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public IntStream getResult() {
        return result;
    }

    public void setResult(IntStream result) {
        this.result = result;
    }
}