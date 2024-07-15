package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.AreaRepository;
import com.codigo.cooperativaahorros.entity.AreaEntity;
import com.codigo.cooperativaahorros.request.AreaRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;

    @Transactional
    public AreaEntity registrarArea(AreaRequest areaRequest) {
        AreaEntity entidad = new AreaEntity();
        entidad.setAreDes(areaRequest.getAreDes());
        entidad.setAreNom(areaRequest.getAreNom());
        entidad.setAreEst('A');
        return areaRepository.save(entidad);
    }

    @Transactional
    public AreaEntity buscarId(Long id) {
        return areaRepository.findById(id).orElseThrow(() -> new RuntimeException("Área no encontrada"));
    }

    @Transactional
    public List<AreaEntity> buscarTodos() {
        return areaRepository.findAll();
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(area -> codigosMap.put(area.getAreCod().intValue(), area.getAreNom()));
        return codigosMap;
    }

    @Transactional
    public AreaEntity actualizar(AreaRequest areaRequest, Long id) {
        AreaEntity entidad = areaRepository.findById(id).orElseThrow(() -> new RuntimeException("Área no encontrada"));
        entidad.setAreDes(areaRequest.getAreDes());
        entidad.setAreNom(areaRequest.getAreNom());
        entidad.setAreEst(areaRequest.getAreEst());
        return areaRepository.save(entidad);
    }

}

