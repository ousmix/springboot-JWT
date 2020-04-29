package com.capgemini.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.springboot.model.AppRole;
import com.capgemini.springboot.model.AppUser;
import com.capgemini.springboot.model.Employee;
import com.capgemini.springboot.repository.EmployeeRepository;
import com.capgemini.springboot.repository.RoleRepository;
import com.capgemini.springboot.repository.UserRepository;
@Service
@Transactional
public class AccountServiceImpl implements AccountService{
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
@Autowired
private EmployeeRepository EmployeeRepository;
@Autowired
private UserRepository  userRepository;
@Autowired
private RoleRepository  roleRepository;
	@Override
	public AppUser saveUser(AppUser user) {
		String hashpw=bCryptPasswordEncoder.encode(user.getPassword());
		
        user.setPassword(hashpw);		
        return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		AppRole role=roleRepository.findByRoleName(roleName);
		AppUser user=userRepository.findByUsername(username);
		user.getRoles().add(role);
	}

	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public List<AppUser> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return EmployeeRepository.save(employee);
	}

}
