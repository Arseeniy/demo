package com.arseeniy.randomize.service;

import com.arseeniy.randomize.common.RequestHistoryEntity;

import java.util.List;

public interface UserService {
    public void addUser(RequestHistoryEntity requestHistoryEntity);
    public List<RequestHistoryEntity> getAllUsers();
    public RequestHistoryEntity getUserById(int id);
}
