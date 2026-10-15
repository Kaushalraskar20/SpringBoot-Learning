package com.xpert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//we cau use @Service, @Componets,@	Bean

@Service
public class HelloService {
		public String getMessage() {
			return "Hello from Spring Boot!";
		}
		@Autowired
	    private StudentRepository repo;
		
		@Autowired
		private UserRepository userRepository; 
	    public List<Students> getAllStudents() {
	        return repo.findAll();
	    }
	    
	 // User CRUD operations
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
}
