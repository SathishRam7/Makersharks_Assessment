package org.ram.controller;

import org.ram.model.User;
import org.ram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
    	User Existinguser=userService.fetchUser(user.getUsername());
    	if(Existinguser!=null) {
    		 return ResponseEntity.status(400).body("Username Already Exists");
    	}
    	if(user.getEmail()==null || user.getUsername()==null || user.getPassword()==null) {
               return ResponseEntity.status(400).body("Invalid request data");
           } 
    
            userService.registerUser(user);
            return ResponseEntity.status(201).body( "User registered successfully");
     
    }
    

    @GetMapping("/fetch")
    public ResponseEntity<User> fetchUser(@RequestParam String username) {
        User user = userService.fetchUser(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

}
