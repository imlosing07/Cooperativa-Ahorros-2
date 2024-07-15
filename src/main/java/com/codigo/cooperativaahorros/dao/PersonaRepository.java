package com.codigo.cooperativaahorros.dao;

import com.codigo.cooperativaahorros.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

}
