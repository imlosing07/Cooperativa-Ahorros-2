package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.ManualRepository;
import com.codigo.cooperativaahorros.dto.ManualDTO;
import com.codigo.cooperativaahorros.entity.ManualEntity;
import com.codigo.cooperativaahorros.request.ManualRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ManualService {
    @Autowired
    private final ManualRepository manualRepository;

    @Transactional
    public ManualEntity registrarManual(ManualRequest manualRequest) {
        ManualEntity entidad = new ManualEntity();
        entidad.setManNom(manualRequest.getManNom());
        entidad.setManDes(manualRequest.getManDes());
        entidad.setManEst('A');
        return manualRepository.save(entidad);
    }

    @Transactional
    public ManualEntity buscarId(Long id) {
        return manualRepository.findById(id).get();
    }

    @Transactional
    public List<ManualDTO> buscarTodos() {
        return manualRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(manual -> codigosMap.put(manual.getManCod(), manual.getManNom()));
        return codigosMap;
    }

    @Transactional
    public ManualEntity actualizar(ManualRequest manualRequest, Long id) {
        ManualEntity entidad = manualRepository.findById(id).orElseThrow(() -> new RuntimeException("Manual no encontrado"));
        entidad.setManNom(manualRequest.getManNom());
        entidad.setManDes(manualRequest.getManDes());
        entidad.setManEst(manualRequest.getManEst());
        return manualRepository.save(entidad);
    }

    private ManualDTO convertirADTO(ManualEntity entidad) {
        ManualDTO dto = new ManualDTO();
        dto.setManCod(entidad.getManCod().intValue());
        dto.setManNom(entidad.getManNom());
        dto.setManDes(entidad.getManDes());
        dto.setManEst(entidad.getManEst());
        return dto;
    }

}
