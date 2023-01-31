package com.byto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.byto.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
 	
    Optional<User> findByEmail(String email);     // Emaile göre kullanıcıları getiriyor
	
}
