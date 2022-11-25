package com.arseeniy.randomize.service.impl;

import com.arseeniy.randomize.common.RequestHistoryEntity;
import com.arseeniy.randomize.repository.UserRepository;
import com.arseeniy.randomize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(RequestHistoryEntity requestHistoryEntity) {
        userRepository.save(requestHistoryEntity);
    }

    public List<RequestHistoryEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public RequestHistoryEntity getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

}

