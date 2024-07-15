package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.TasaRepository;
import com.codigo.cooperativaahorros.entity.TasaEntity;
import com.codigo.cooperativaahorros.request.TasaRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class TasaService {

    private final TasaRepository tasaRepository;

    @Transactional
    public TasaEntity registrarTasa(TasaRequest tasaRequest) {
        TasaEntity entidad = new TasaEntity();
        entidad.setTasIden(tasaRequest.getTasIden());
        entidad.setTasDesc(tasaRequest.getTasDesc());
        entidad.setTasTasa(tasaRequest.getTasTasa());
        entidad.setTasFecIni(tasaRequest.getTasFecIni());
        entidad.setTasFecFin(tasaRequest.getTasFecFin());
        entidad.setTasPlaDia(calcularDiferenciaDias(tasaRequest.getTasFecIni(), tasaRequest.getTasFecFin()));
        entidad.setTasEst(tasaRequest.getTasEst());
        return tasaRepository.save(entidad);
    }

    private int calcularDiferenciaDias(Date fechaInicio, Date fechaFin) {
        long diffInMillies = Math.abs(fechaFin.getTime() - fechaInicio.getTime());
        return (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    @Transactional
    public TasaEntity buscarId(Long id) {
        return tasaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tasa no encontrada"));
    }

    @Transactional
    public List<TasaEntity> buscarTodos() {
        return tasaRepository.findAll();
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(tasa -> codigosMap.put(tasa.getTasCod().intValue(), tasa.getTasIden()));
        return codigosMap;
    }

    @Transactional
    public TasaEntity actualizar(TasaRequest tasaRequest, Long id) {
        TasaEntity entidad = tasaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tasa no encontrada"));
        entidad.setTasIden(tasaRequest.getTasIden());
        entidad.setTasDesc(tasaRequest.getTasDesc());
        entidad.setTasTasa(tasaRequest.getTasTasa());
        entidad.setTasPlaDia(calcularDiferenciaDias(tasaRequest.getTasFecIni(), tasaRequest.getTasFecFin()));
        entidad.setTasFecIni(tasaRequest.getTasFecIni());
        entidad.setTasFecFin(tasaRequest.getTasFecFin());
        entidad.setTasEst(tasaRequest.getTasEst());
        return tasaRepository.save(entidad);
    }
}
