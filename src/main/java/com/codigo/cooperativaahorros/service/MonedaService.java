package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.MonedaRepository;
import com.codigo.cooperativaahorros.entity.MonedaEntity;
import com.codigo.cooperativaahorros.request.MonedaRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MonedaService {

    private final MonedaRepository monedaRepository;

    @Transactional
    public MonedaEntity registrarMoneda(MonedaRequest monedaRequest) {
        MonedaEntity entidad = new MonedaEntity();
        entidad.setMonNom(monedaRequest.getMonNom());
        entidad.setMonEst('A');
        return monedaRepository.save(entidad);
    }

    @Transactional
    public MonedaEntity buscarId(Long id) {
        return monedaRepository.findById(id).orElseThrow(() -> new RuntimeException("Moneda no encontrada"));
    }

    @Transactional
    public List<MonedaEntity> buscarTodos() {
        return monedaRepository.findAll();
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(moneda -> codigosMap.put(moneda.getMonCod().intValue(), moneda.getMonNom()));
        return codigosMap;
    }

    @Transactional
    public MonedaEntity actualizar(MonedaRequest monedaRequest, Long id) {
        MonedaEntity entidad = monedaRepository.findById(id).orElseThrow(() -> new RuntimeException("Moneda no encontrada"));
        entidad.setMonNom(monedaRequest.getMonNom());
        entidad.setMonEst(monedaRequest.getMonEst());
        return monedaRepository.save(entidad);
    }

}
