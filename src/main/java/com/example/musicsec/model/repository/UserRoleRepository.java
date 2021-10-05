package com.example.musicsec.model.repository;

import com.example.musicsec.model.entity.UserRoleEntity;
import com.example.musicsec.model.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    Optional<UserRoleEntity> findByRole (UserRole role);
}
