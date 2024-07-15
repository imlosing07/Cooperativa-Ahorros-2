package com.codigo.cooperativaahorros.dao;

import com.codigo.cooperativaahorros.entity.LogAccionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogAccionesRepository extends JpaRepository<LogAccionesEntity, Long> {
}
