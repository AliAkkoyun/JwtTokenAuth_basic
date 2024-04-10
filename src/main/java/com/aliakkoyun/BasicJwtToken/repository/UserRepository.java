package com.aliakkoyun.BasicJwtToken.repository;

import com.aliakkoyun.BasicJwtToken.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);
}
