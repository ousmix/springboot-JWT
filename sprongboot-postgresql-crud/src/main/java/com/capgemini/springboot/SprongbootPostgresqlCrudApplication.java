package com.capgemini.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.capgemini.springboot.model.AppRole;
import com.capgemini.springboot.model.AppUser;
import com.capgemini.springboot.model.Employee;
import com.capgemini.springboot.service.AccountService;

@SpringBootApplication 
public class SprongbootPostgresqlCrudApplication implements CommandLineRunner{
	@Autowired
	private AccountService AccountService;
	

	public static void main(String[] args) {
		SpringApplication.run(SprongbootPostgresqlCrudApplication.class, args);
	}
@Bean
public BCryptPasswordEncoder getBCPE(){
	return new BCryptPasswordEncoder();
}
@Override
public void run(String... args) throws Exception {
	AccountService.saveUser(new AppUser(null, "admin", "1234", null));
	AccountService.saveUser(new AppUser(null, "user", "1234", null));
	AccountService.saveRole(new AppRole(null, "ADMIN"));
	AccountService.saveRole(new AppRole(null, "USER"));
	AccountService.addRoleToUser("admin", "ADMIN");
	AccountService.addRoleToUser("admin", "USER");
	AccountService.addRoleToUser("user", "USER");
	AccountService.saveEmployee(new Employee(null, "oussama", "eddai", "oussama.eddai@gmail.com"));
	AccountService.saveEmployee(new Employee(null, "khadija", "baidek", "khadija.baidek@gmail.com"));
	AccountService.saveEmployee(new Employee(null, "ahmed", "bakri", "ahmed.bakri@gmail.com"));
}



}
