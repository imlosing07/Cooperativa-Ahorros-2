package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.RolRepository;
import com.codigo.cooperativaahorros.dto.RolDTO;
import com.codigo.cooperativaahorros.entity.FuncionesEntity;
import com.codigo.cooperativaahorros.entity.RolEntity;
import com.codigo.cooperativaahorros.entity.UsuarioEntity;
import com.codigo.cooperativaahorros.request.RolRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RolService {
    private final RolRepository rolRepository;

    @Transactional
    public RolEntity registrarRol(RolRequest rolRequest) {
        RolEntity entidad = new RolEntity();
        entidad.setRolRol(rolRequest.getRolRol());
        entidad.setRolNom(rolRequest.getRolNom());
        entidad.setRolEst('A');
        return rolRepository.save(entidad);
    }

    @Transactional
    public RolEntity buscarId(Long id) {
        return rolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));
    }

    @Transactional
    public List<RolDTO> buscarTodos() {
        List<RolEntity> roles = rolRepository.findAll();
        return roles.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(rol -> codigosMap.put(rol.getRolCod(),rol.getRolNom()));
        return codigosMap;
    }

    @Transactional
    public RolEntity actualizar(RolRequest rolRequest, Long id) {
        RolEntity entidad = rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        entidad.setRolRol(rolRequest.getRolRol());
        entidad.setRolNom(rolRequest.getRolNom());
        entidad.setRolEst(rolRequest.getRolEst());
        return rolRepository.save(entidad);
    }

    private RolDTO convertToDto(RolEntity rolEntity) {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setRolCod(rolEntity.getRolCod().intValue());
        rolDTO.setRolRol(rolEntity.getRolRol());
        rolDTO.setRolNom(rolEntity.getRolNom());
        rolDTO.setUsuarios(rolEntity.getUsuarios().stream().map(UsuarioEntity::getUsuUsu).collect(Collectors.joining(", ")));
        rolDTO.setRolEst(rolEntity.getRolEst());
        return rolDTO;
    }

}
