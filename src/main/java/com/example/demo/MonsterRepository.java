package com.example.demo;

import com.example.demo.entities.Account;
import com.example.demo.entities.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Long> {}
