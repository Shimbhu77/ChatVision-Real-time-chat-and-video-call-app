package com.chatvision.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatvision.model.Chat;

@Repository
public interface ChatRepo extends JpaRepository<Chat, Integer> {

}
