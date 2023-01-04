package com.arseeniy.randomize.service.impl;

import com.arseeniy.randomize.common.RandomNumber;
import com.arseeniy.randomize.common.RequestHistoryEntity;
import com.arseeniy.randomize.repository.RequestHistoryRepository;
import com.arseeniy.randomize.service.RequestHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class RequestHistoryServiceImpl implements RequestHistoryService {
    @Autowired
    private RequestHistoryRepository requestHistoryRepository;

    public void addUser(int min, int max, String name, RandomNumber randomNumber) {
        RequestHistoryEntity currentRequestHistoryEntity = new RequestHistoryEntity();
        currentRequestHistoryEntity.setMin(min);
        currentRequestHistoryEntity.setMax(max);
        currentRequestHistoryEntity.setName(name);
        currentRequestHistoryEntity.setDate(new Date());
        currentRequestHistoryEntity.setResult(randomNumber.getResult());
        requestHistoryRepository.save(currentRequestHistoryEntity);
    }

    public List<RequestHistoryEntity> getAllUsers() {
        return requestHistoryRepository.findAll();
    }

    public RequestHistoryEntity getUserById(int id) {
        return requestHistoryRepository.findById(id).orElse(null);
    }

}

