package com.arseeniy.randomize.service;

import com.arseeniy.randomize.common.RandomNumber;
import com.arseeniy.randomize.common.RequestHistoryEntity;

import java.util.List;

public interface RequestHistoryService {
    public void addUser(int min, int max, String name, RandomNumber randomNumber);
    public List<RequestHistoryEntity> getAllUsers();
    public RequestHistoryEntity getUserById(int id);
}
