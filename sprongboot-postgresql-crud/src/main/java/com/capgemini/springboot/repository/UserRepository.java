package com.capgemini.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.springboot.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long>{
public AppUser findByUsername(String usename);	

}
