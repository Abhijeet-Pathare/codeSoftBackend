package com.codesoft.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesoft.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
