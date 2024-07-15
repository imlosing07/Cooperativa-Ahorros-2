package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.ProductoRepository;
import com.codigo.cooperativaahorros.dto.ProductoDTO;
import com.codigo.cooperativaahorros.entity.ProductoEntity;
import com.codigo.cooperativaahorros.request.ProductoRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final TasaService tasaService;
    private final MonedaService monedaService;
    private final SocioService socioService;

    @Transactional
    public ProductoEntity registrarProducto(ProductoRequest productoRequest) {
        ProductoEntity entidad = new ProductoEntity();
        entidad.setProIden(productoRequest.getProIden());
        entidad.setProDes(productoRequest.getProDes());
        entidad.setTasa(tasaService.buscarId(productoRequest.getTasa()));
        entidad.setMoneda(monedaService.buscarId(productoRequest.getMoneda()));
        entidad.setSocio(socioService.buscarId(productoRequest.getSocio()));
        entidad.setProEst('A');
        productoRepository.save(entidad);
        entidad.getSocio().getProductos().add(entidad);
        return entidad;
    }

    @Transactional
    public ProductoEntity buscarId(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Transactional
    public List<ProductoDTO> buscarTodos() {
        return productoRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Transactional
    public ProductoEntity actualizar(ProductoRequest productoRequest, Long id) {
        ProductoEntity entidad = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        entidad.setProIden(productoRequest.getProIden());
        entidad.setProDes(productoRequest.getProDes());
        entidad.setTasa(tasaService.buscarId(productoRequest.getTasa()));
        entidad.setMoneda(monedaService.buscarId(productoRequest.getMoneda()));
        entidad.setSocio(socioService.buscarId(productoRequest.getSocio()));
        entidad.setProEst(productoRequest.getProEst());
        productoRepository.save(entidad);
        entidad.getSocio().getProductos().add(entidad);
        return entidad;
    }

    private ProductoDTO convertirADTO(ProductoEntity entidad) {
        ProductoDTO dto = new ProductoDTO();
        dto.setProCod(entidad.getProCod().intValue());
        dto.setProIden(entidad.getProIden());
        dto.setProDes(entidad.getProDes());
        dto.setTasTasa(entidad.getTasa().getTasTasa());
        dto.setMonNom(entidad.getMoneda().getMonNom());
        dto.setSocNom(entidad.getSocio().getSocNom());
        dto.setProEst(entidad.getProEst());
        return dto;
    }

}
