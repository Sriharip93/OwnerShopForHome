package com.srihari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srihari.entity.Owner;

@Repository
public interface OwnerRepository  extends JpaRepository<Owner, Integer>{

}
