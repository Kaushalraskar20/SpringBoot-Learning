package com.xpert;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController
public class HelloController {
    private final HelloService helloService;
 
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }
    
//    @GetMapping("/view-users")
 
    @GetMapping("/hello")
    public String sayHello() {
        return helloService.getMessage();
    }

   

    @GetMapping("/students")
    public String viewStudents(Model model) {

        List<Students> list = helloService.getAllStudents();

        model.addAttribute("students", list);

        return "students"; // will go to students.html
    }
    
    @GetMapping("/users1")
//    public List<User> getAllUsers() {
//        return helloService.getAllUsers();
    	
    	public List<User> getAllUsers(Model model ) {
    	List<User> list = helloService.getAllUsers();
        model.addAttribute("users", list); // Passes the list to HTML
        return helloService.getAllUsers();
    }
    
    
}