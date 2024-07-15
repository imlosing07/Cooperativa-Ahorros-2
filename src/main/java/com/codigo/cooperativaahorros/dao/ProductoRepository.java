package com.codigo.cooperativaahorros.dao;

import com.codigo.cooperativaahorros.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {
}
