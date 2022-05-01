package com.example.springBootdemo2.repository;

import com.example.springBootdemo2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> { }
