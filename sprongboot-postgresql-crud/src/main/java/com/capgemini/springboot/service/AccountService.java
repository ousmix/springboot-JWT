package com.capgemini.springboot.service;

import java.util.List;

import com.capgemini.springboot.model.AppRole;
import com.capgemini.springboot.model.AppUser;
import com.capgemini.springboot.model.Employee;

public interface AccountService {
public AppUser saveUser(AppUser user);
public AppRole saveRole(AppRole role);
public void addRoleToUser(String username,String roleName);
public AppUser findUserByUsername(String username);
public List<AppUser> findAll();
public Employee saveEmployee(Employee employee);
}
