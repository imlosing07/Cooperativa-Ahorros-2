package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.DireccionRepository;
import com.codigo.cooperativaahorros.dto.DireccionDTO;
import com.codigo.cooperativaahorros.entity.DireccionEntity;
import com.codigo.cooperativaahorros.request.DireccionRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class DireccionService {

    private final DireccionRepository direccionRepository;

    @Transactional
    public DireccionEntity registrarDireccion(DireccionRequest direccionRequest) {
        DireccionEntity entidad = new DireccionEntity();
        entidad.setDirDep(direccionRequest.getDirDep());
        entidad.setDirPro(direccionRequest.getDirPro());
        entidad.setDirDis(direccionRequest.getDirDis());
        entidad.setDirEst(direccionRequest.getDirEst());
        return direccionRepository.save(entidad);
    }

    @Transactional
    public DireccionEntity buscarId(Long id) {
        return direccionRepository.findById(id).orElseThrow(() -> new RuntimeException("Dirección no encontrada"));
    }

    @Transactional
    public List<DireccionDTO> buscarTodos() {
        return direccionRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(direccion -> codigosMap.put(direccion.getDirCod().intValue(), direccion.getDirDep() + " - " + direccion.getDirPro() + " - " + direccion.getDirDis()));
        return codigosMap;
    }

    @Transactional
    public DireccionEntity actualizar(DireccionRequest direccionRequest, Long id) {
        DireccionEntity entidad = direccionRepository.findById(id).orElseThrow(() -> new RuntimeException("Dirección no encontrada"));
        entidad.setDirDep(direccionRequest.getDirDep());
        entidad.setDirPro(direccionRequest.getDirPro());
        entidad.setDirDis(direccionRequest.getDirDis());
        entidad.setDirEst(direccionRequest.getDirEst());
        return direccionRepository.save(entidad);
    }

    private DireccionDTO convertirADTO(DireccionEntity entidad) {
        DireccionDTO dto = new DireccionDTO();
        dto.setDirCod(entidad.getDirCod().intValue());
        dto.setDirDep(entidad.getDirDep());
        dto.setDirPro(entidad.getDirPro());
        dto.setDirDis(entidad.getDirDis());
        dto.setDirEst(entidad.getDirEst());
        return dto;
    }

}
