package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "select count(email) from user where email=?1", nativeQuery = true)
    int findByEmail(String email);
}
