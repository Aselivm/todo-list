package com.primshic.stepan.repository;

import java.util.Optional;

import com.primshic.stepan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

}
