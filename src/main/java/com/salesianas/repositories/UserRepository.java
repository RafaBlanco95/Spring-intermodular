package com.salesianas.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	
	User findByUsername(String username);
}