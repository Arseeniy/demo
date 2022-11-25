package com.arseeniy.randomize.repository;

import com.arseeniy.randomize.common.RequestHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<RequestHistoryEntity, Integer> {
}
