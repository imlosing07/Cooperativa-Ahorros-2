package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.AccionRepository;
import com.codigo.cooperativaahorros.dto.AccionDTO;
import com.codigo.cooperativaahorros.entity.AccionEntity;
import com.codigo.cooperativaahorros.request.AccionRequest;
import com.codigo.cooperativaahorros.entity.LogAccionesEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccionService {

    private final AccionRepository accionRepository;
    private final LogAccionesService logAccionesService;

    @Transactional
    public AccionEntity registrarAccion(AccionRequest accionRequest) {
        AccionEntity entidad = new AccionEntity();
        entidad.setLogAccionesCod(logAccionesService.buscarId(accionRequest.getLogAccionesCod()));
        entidad.setAccDes(accionRequest.getAccDes());
        entidad.setAccEst('A');
        return accionRepository.save(entidad);
    }

    @Transactional
    public AccionEntity buscarId(Long id) {
        return accionRepository.findById(id).orElseThrow(() -> new RuntimeException("Acción no encontrada"));
    }

    @Transactional
    public List<AccionDTO> buscarTodos() {
        return accionRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Transactional
    public AccionEntity actualizar(AccionRequest accionRequest, Long id) {
        AccionEntity entidad = accionRepository.findById(id).orElseThrow(() -> new RuntimeException("Acción no encontrada"));
        entidad.setLogAccionesCod(logAccionesService.buscarId(accionRequest.getLogAccionesCod()));
        entidad.setAccDes(accionRequest.getAccDes());
        entidad.setAccEst(accionRequest.getAccEst());
        return accionRepository.save(entidad);
    }

    private AccionDTO convertToDto(AccionEntity accionEntity) {
        AccionDTO accionDTO = new AccionDTO();
        accionDTO.setAccCod(accionEntity.getAccCod().intValue());
        accionDTO.setAccDes(accionEntity.getAccDes());
        accionDTO.setLogAccionesCod(accionEntity.getLogAccionesCod().getLogAccionesCod().intValue());
        accionDTO.setAccEst(accionEntity.getAccEst());
        return accionDTO;
    }

}

