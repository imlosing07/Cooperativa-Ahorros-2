package com.codigo.cooperativaahorros.dao;

import com.codigo.cooperativaahorros.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<CuentaEntity,Long> {
}
