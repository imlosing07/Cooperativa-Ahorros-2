package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.SolucionRepository;
import com.codigo.cooperativaahorros.entity.SolucionEntity;
import com.codigo.cooperativaahorros.request.SolucionRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SolucionService {

    private final SolucionRepository solucionRepository;

    @Transactional
    public SolucionEntity registrarSolucion(SolucionRequest solucionRequest) {
        SolucionEntity entidad = new SolucionEntity();
        entidad.setSolNom(solucionRequest.getSolNom());
        entidad.setSolDes(solucionRequest.getSolDes());
        entidad.setSolFec(getDate());
        entidad.setSolEst('A');
        return solucionRepository.save(entidad);
    }

    @Transactional
    public SolucionEntity buscarId(Long id) {
        return solucionRepository.findById(id).orElseThrow(() -> new RuntimeException("Solución no encontrada"));
    }

    @Transactional
    public List<SolucionEntity> buscarTodos() {
        return solucionRepository.findAll();
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(solucion -> codigosMap.put(solucion.getSolCod().intValue(), solucion.getSolNom()));
        return codigosMap;
    }

    @Transactional
    public SolucionEntity actualizar(SolucionRequest solucionRequest, Long id) {
        SolucionEntity entidad = solucionRepository.findById(id).orElseThrow(() -> new RuntimeException("Solución no encontrada"));
        entidad.setSolNom(solucionRequest.getSolNom());
        entidad.setSolDes(solucionRequest.getSolDes());
        entidad.setSolFec(solucionRequest.getSolFec());
        entidad.setSolEst(solucionRequest.getSolEst());
        return solucionRepository.save(entidad);
    }

    private Date getDate(){
        System.out.println("Fecha: " + new Date(System.currentTimeMillis()));
        return new Date(System.currentTimeMillis());
    }

}
