package com.codigo.cooperativaahorros.dao;

import com.codigo.cooperativaahorros.entity.ManualEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ManualRepository extends JpaRepository<ManualEntity,Long> {
    Optional<ManualEntity> findByManNom(String manNom);

    @Query("SELECT m FROM ManualEntity m WHERE m.funciones IS NULL")
    List<ManualEntity> findUnusedManuals();
}
