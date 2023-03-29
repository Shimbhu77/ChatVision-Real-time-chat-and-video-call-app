package com.chatvision.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatvision.model.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {

}
