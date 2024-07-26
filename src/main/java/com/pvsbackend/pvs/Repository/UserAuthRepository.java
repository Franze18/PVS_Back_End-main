package com.pvsbackend.pvs.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvsbackend.pvs.Model.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long>{
    Optional<UserAuth> findByUsername(String username);
    Optional<UserAuth> findByEmail(String email);
    Optional<UserAuth> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}