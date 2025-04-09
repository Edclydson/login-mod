package com.api.master.loginmod.repository;

import com.api.master.loginmod.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByUserName(String userName);

    Optional<User> findByEmail(String email);
}
