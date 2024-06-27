package com.primshic.stepan.repository;

import java.util.List;
import java.util.Optional;

import com.primshic.stepan.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer> {
  Optional<Token> findByToken(String token);
}
