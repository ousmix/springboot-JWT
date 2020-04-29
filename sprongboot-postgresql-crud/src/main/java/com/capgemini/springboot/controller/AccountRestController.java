package com.capgemini.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.model.AppRole;
import com.capgemini.springboot.model.AppUser;
import com.capgemini.springboot.model.Employee;
import com.capgemini.springboot.repository.UserRepository;
import com.capgemini.springboot.service.AccountService;

@RestController
/*@Configuration
@ComponentScan("com.capgemini.springboot.controller")*/
public class AccountRestController {
	@Autowired
	AccountService accountService;
	@PostMapping("/register")
public AppUser register(@RequestBody RegisterForm userForm){
		if(!userForm.getPassword().equals(userForm.getRepassword()))
				throw new RuntimeException("you must confirm your password");
		AppUser user = accountService.findUserByUsername(userForm.getUsername());
		if(user!=null)throw new RuntimeException("this user is already exists");
		AppUser appUser=new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
	 accountService.saveUser(appUser);
	 accountService.addRoleToUser(userForm.getUsername(), "USER");
	 return appUser;
	}
	
	@GetMapping("/register")
	public List<AppUser> getAllUsers() {
		return accountService.findAll();
	}
	
	@PostMapping("/role")
	public AppRole register(@RequestBody AppRole role){
		return accountService.saveRole(role);
}
 
}
