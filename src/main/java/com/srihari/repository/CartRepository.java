package com.srihari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srihari.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
