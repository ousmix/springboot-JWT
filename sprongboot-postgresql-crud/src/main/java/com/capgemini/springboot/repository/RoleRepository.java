package com.capgemini.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.springboot.model.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long>{
public AppRole findByRoleName(String roleName);
}
