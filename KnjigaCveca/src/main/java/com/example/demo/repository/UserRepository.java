package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.username = :n AND u.email = :e")
	boolean existsByUsernameOrEmail(@Param("n") String username, @Param("e") String email);

	@Query("SELECT u FROM User u WHERE u.username = :n AND u.password = :p")
	User findByUsernameAndPassword(@Param("n") String username, @Param("p") String password);
    
	@Query("SELECT u FROM User u WHERE u.email = :e")
	User findByEmail(@Param("e") String email);

	User findByUsername(String username);
	
	@Query("SELECT u FROM User u WHERE u.username = :user")
	User getByName(@Param("user")String username);

}
