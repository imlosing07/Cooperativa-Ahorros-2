package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.UsuarioRepository;
import com.codigo.cooperativaahorros.dto.UsuarioDTO;
import com.codigo.cooperativaahorros.entity.UsuarioEntity;
import com.codigo.cooperativaahorros.request.UsuarioRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final CooperativaService cooperativaService;
    private final RolService rolService;

    @Transactional
    public UsuarioEntity registrarUsuario(UsuarioRequest usuarioRequest) {
        UsuarioEntity entidad = new UsuarioEntity();
        entidad.setUsuIde(usuarioRequest.getUsuIde());
        entidad.setUsuUsu(usuarioRequest.getUsuUsu());
        entidad.setUsuPas(usuarioRequest.getUsuPas());
        entidad.setCooperativa(cooperativaService.buscarId(usuarioRequest.getCooperativa()));
        entidad.setRol(rolService.buscarId(usuarioRequest.getRol()));
        entidad.setUsuEst('A');
        usuarioRepository.save(entidad);
        entidad.getCooperativa().getUsuarios().add(entidad);
        entidad.getRol().getUsuarios().add(entidad);
        return entidad;
    }

    @Transactional
    public UsuarioEntity buscarId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Transactional
    public List<UsuarioDTO> buscarTodos() {
        return usuarioRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(usuarioDTO -> codigosMap.put(usuarioDTO.getUsuCod(), usuarioDTO.getUsuUsu()));
        return codigosMap;
    }

    @Transactional
    public UsuarioEntity actualizar(UsuarioRequest usuarioRequest, Long id) {
        UsuarioEntity entidad = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        entidad.setUsuIde(usuarioRequest.getUsuIde());
        entidad.setUsuUsu(usuarioRequest.getUsuUsu());
        entidad.setUsuPas(usuarioRequest.getUsuPas());
        entidad.setCooperativa(cooperativaService.buscarId(usuarioRequest.getCooperativa()));
        entidad.setRol(rolService.buscarId(usuarioRequest.getRol()));
        entidad.setUsuEst(usuarioRequest.getUsuEst());
        usuarioRepository.save(entidad);
        entidad.getRol().getUsuarios().add(entidad);
        return entidad;
    }

    private UsuarioDTO convertirADTO(UsuarioEntity entidad) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsuCod(entidad.getUsuCod().intValue());
        dto.setUsuIde(entidad.getUsuIde());
        dto.setUsuUsu(entidad.getUsuUsu());
        dto.setUsuPas(entidad.getUsuPas());
        dto.setCooperativa(entidad.getCooperativa().getCooNom());
        dto.setRol(entidad.getRol().getRolNom());
        dto.setUsuEst(entidad.getUsuEst());
        return dto;
    }

}
