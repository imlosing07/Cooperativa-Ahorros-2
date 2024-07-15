package com.codigo.cooperativaahorros.dao;

import com.codigo.cooperativaahorros.entity.SocioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<SocioEntity,Long> {
}
