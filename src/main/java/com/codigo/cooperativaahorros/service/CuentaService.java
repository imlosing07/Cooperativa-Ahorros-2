package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.CuentaRepository;
import com.codigo.cooperativaahorros.entity.CuentaEntity;
import com.codigo.cooperativaahorros.request.CuentaRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    @Transactional
    public CuentaEntity registrarCuenta(CuentaRequest cuentaRequest) {
        CuentaEntity entidad = new CuentaEntity();
        entidad.setCueNum(cuentaRequest.getCueNum());
        entidad.setCueEst('A');
        return cuentaRepository.save(entidad);
    }

    @Transactional
    public CuentaEntity buscarId(Long id) {
        return cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    @Transactional
    public List<CuentaEntity> buscarTodos() {
        return cuentaRepository.findAll();
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(cuenta -> codigosMap.put(cuenta.getCueCod().intValue(), cuenta.getCueNum().toString()));
        return codigosMap;
    }

    @Transactional
    public CuentaEntity actualizar(CuentaRequest cuentaRequest, Long id) {
        CuentaEntity entidad = cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        entidad.setCueNum(cuentaRequest.getCueNum());
        entidad.setCueEst(cuentaRequest.getCueEst());
        return cuentaRepository.save(entidad);
    }

}
