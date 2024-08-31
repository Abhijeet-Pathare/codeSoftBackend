package com.codesoft.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesoft.app.dto.UserDto;
import com.codesoft.app.entities.Role;
import com.codesoft.app.entities.User;
import com.codesoft.app.repositories.RoleRepository;
import com.codesoft.app.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private RoleRepository roleRepository;

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
		Role role = roleRepository.findById(userDto.getRoleId())
				.orElseThrow(() -> new RuntimeException("Role not found"));

		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setRole(role);

		User savedUser = userService.saveUser(user);
		return ResponseEntity.ok(savedUser);
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return userService.findByUsername(username);
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.findAll();
	}
}
