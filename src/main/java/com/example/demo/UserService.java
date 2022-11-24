package com.example.demo;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> getAllUsers();
    public User getUserById(int id);
    public RandomNumber getRandomNumber(int min, int max);

}
