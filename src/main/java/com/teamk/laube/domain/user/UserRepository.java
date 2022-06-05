package com.teamk.laube.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
