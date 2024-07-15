package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.CooperativaRepository;
import com.codigo.cooperativaahorros.dto.CooperativaDTO;
import com.codigo.cooperativaahorros.entity.CooperativaEntity;
import com.codigo.cooperativaahorros.request.CooperativaRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CooperativaService {
    private final CooperativaRepository cooperativaRepository;
    @Transactional
    public CooperativaEntity registarCooperativa(CooperativaRequest cooperativaRequest) {
        CooperativaEntity entidad = new CooperativaEntity();
        entidad.setCooIden(cooperativaRequest.getCooIden());
        entidad.setCooNom(cooperativaRequest.getCooNom());
        entidad.setCooSlo(cooperativaRequest.getCooSlo());
        entidad.setCooSig(cooperativaRequest.getCooSig());
        entidad.setCooDir(cooperativaRequest.getCooDir());
        entidad.setCooTel(cooperativaRequest.getCooTel());
        entidad.setCooCor(cooperativaRequest.getCooCor());
        entidad.setCooLog(cooperativaRequest.getCooLog());
        entidad.setCooEst('A');
        return cooperativaRepository.save(entidad);
    }

    @Transactional
    public CooperativaEntity buscarId(Long id) {
        return cooperativaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cooperativa no encontrada"));
    }

    @Transactional
    public List<CooperativaDTO> buscarTodos(){
        return cooperativaRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(cooperativa -> codigosMap.put(cooperativa.getCooCod().intValue(), cooperativa.getCooNom()));
        return codigosMap;
    }

    @Transactional
    public CooperativaEntity actualizar(CooperativaRequest cooperativaRequest, Long id){
        CooperativaEntity entity = cooperativaRepository.findById(id).get();
        entity.setCooIden(cooperativaRequest.getCooIden());
        entity.setCooNom(cooperativaRequest.getCooNom());
        entity.setCooSlo(cooperativaRequest.getCooSlo());
        entity.setCooSig(cooperativaRequest.getCooSig());
        entity.setCooDir(cooperativaRequest.getCooDir());
        entity.setCooTel(cooperativaRequest.getCooTel());
        entity.setCooCor(cooperativaRequest.getCooCor());
        entity.setCooLog(cooperativaRequest.getCooLog());

        entity.setCooEst(cooperativaRequest.getCooEst());
        return cooperativaRepository.save(entity);
    }

    private CooperativaDTO convertirADTO(CooperativaEntity cooperativaEntity) {
        CooperativaDTO cooperativaDTO = new CooperativaDTO();
        cooperativaDTO.setCooCod(cooperativaEntity.getCooCod());
        cooperativaDTO.setCooIden(cooperativaEntity.getCooIden());
        cooperativaDTO.setCooNom(cooperativaEntity.getCooNom());
        cooperativaDTO.setCooDir(cooperativaEntity.getCooDir());
        cooperativaDTO.setCooTel(cooperativaEntity.getCooTel());
        cooperativaDTO.setCooCor(cooperativaEntity.getCooCor());
        cooperativaDTO.setCooSlo(cooperativaEntity.getCooSlo());
        cooperativaDTO.setUsuarios(cooperativaEntity.getUsuarios().stream().map(usuario -> usuario.getUsuUsu().toString()).collect(Collectors.joining(",")));
        cooperativaDTO.setSocios(cooperativaEntity.getSocios().stream().map(socio -> socio.getSocNom().toString()).collect(Collectors.joining(",")));
        cooperativaDTO.setCooEst(cooperativaEntity.getCooEst());
        return cooperativaDTO;
    }




}
