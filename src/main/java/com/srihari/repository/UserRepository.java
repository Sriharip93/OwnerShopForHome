package com.srihari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srihari.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{

}
