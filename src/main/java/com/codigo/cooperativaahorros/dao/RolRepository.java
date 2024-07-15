package com.codigo.cooperativaahorros.dao;

import com.codigo.cooperativaahorros.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<RolEntity,Long> {
    Optional<RolEntity> findByRolNom(String rolNom);
}
