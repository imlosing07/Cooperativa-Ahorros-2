package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.DispositivoRepository;
import com.codigo.cooperativaahorros.entity.DispositivoEntity;
import com.codigo.cooperativaahorros.request.DispositivoRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class DispositivoService {

    private final DispositivoRepository dispositivoRepository;

    @Transactional
    public DispositivoEntity registrarDispositivo(DispositivoRequest dispositivoRequest) {
        DispositivoEntity entidad = new DispositivoEntity();
        entidad.setDisNom(dispositivoRequest.getDisNom());
        entidad.setDisDirIp(dispositivoRequest.getDisDirIp());
        entidad.setDisEst('A');
        return dispositivoRepository.save(entidad);
    }

    @Transactional
    public DispositivoEntity buscarId(Long id) {
        return dispositivoRepository.findById(id).orElseThrow(() -> new RuntimeException("Dispositivo no encontrado"));
    }

    @Transactional
    public List<DispositivoEntity> buscarTodos() {
        return dispositivoRepository.findAll();
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(dispositivoEntity -> codigosMap.put(dispositivoEntity.getDisCod().intValue(), dispositivoEntity.getDisNom()));
        return codigosMap;
    }

    @Transactional
    public DispositivoEntity actualizar(DispositivoRequest dispositivoRequest, Long id) {
        DispositivoEntity entidad = dispositivoRepository.findById(id).orElseThrow(() -> new RuntimeException("Dispositivo no encontrado"));
        entidad.setDisNom(dispositivoRequest.getDisNom());
        entidad.setDisDirIp(dispositivoRequest.getDisDirIp());
        entidad.setDisEst(dispositivoRequest.getDisEst());
        return dispositivoRepository.save(entidad);
    }

}
