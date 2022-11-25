package com.arseeniy.randomize.common;

public class RandomNumber {
    int min;
    int max;
    int result;

    public RandomNumber(int min, int max, int result) {
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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}