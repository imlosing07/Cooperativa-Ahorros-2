package com.codigo.cooperativaahorros.dao;

import com.codigo.cooperativaahorros.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
}
