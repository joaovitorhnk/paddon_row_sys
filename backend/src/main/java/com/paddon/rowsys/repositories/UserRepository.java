package com.paddon.rowsys.repositories;

import com.paddon.rowsys.domain.model.UserModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<UserModal, Long> {
    Optional<UserModal> findByUsername(String username);
}
