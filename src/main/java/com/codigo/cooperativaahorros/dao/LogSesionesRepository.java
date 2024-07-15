package com.codigo.cooperativaahorros.dao;

import com.codigo.cooperativaahorros.entity.LogSesionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogSesionesRepository extends JpaRepository<LogSesionesEntity,Long> {
}
