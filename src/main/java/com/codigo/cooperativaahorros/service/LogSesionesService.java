package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.LogSesionesRepository;
import com.codigo.cooperativaahorros.dto.LogSesionesDTO;
import com.codigo.cooperativaahorros.entity.LogSesionesEntity;
import com.codigo.cooperativaahorros.request.LogSesionesRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class LogSesionesService {

    private final LogSesionesRepository logSesionesRepository;
    private final UsuarioService usuarioService;
    private final DispositivoService dispositivoService;

    @Transactional
    public LogSesionesEntity registrarLogSesiones(LogSesionesRequest logSesionesRequest) {
        LogSesionesEntity entidad = new LogSesionesEntity();
        entidad.setDia(logSesionesRequest.getDia());
        entidad.setUsuario(usuarioService.buscarId(logSesionesRequest.getUsuario()));
        entidad.setDispositivo(dispositivoService.buscarId(logSesionesRequest.getDispositivo()));
        entidad.setLogSesionesEst('A');
        return logSesionesRepository.save(entidad);
    }

    @Transactional
    public LogSesionesEntity buscarId(Long id) {
        return logSesionesRepository.findById(id).orElseThrow(() -> new RuntimeException("Log de sesiones no encontrado"));
    }

    @Transactional
    public List<LogSesionesDTO> buscarTodos() {
        return logSesionesRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Transactional
    public List<Long> buscarCodigos() {
        return buscarTodos().stream().map(LogSesionesDTO::getLogSesionCod).toList();
    }

    @Transactional
    public LogSesionesEntity actualizar(LogSesionesRequest logSesionesRequest, Long id) {
        LogSesionesEntity entidad = logSesionesRepository.findById(id).orElseThrow(() -> new RuntimeException("Log de sesiones no encontrado"));
        entidad.setDia(logSesionesRequest.getDia());
        entidad.setUsuario(usuarioService.buscarId(logSesionesRequest.getUsuario()));
        entidad.setDispositivo(dispositivoService.buscarId(logSesionesRequest.getDispositivo()));
        entidad.setLogSesionesEst(logSesionesRequest.getLogSesionesEst());
        return logSesionesRepository.save(entidad);
    }

    private LogSesionesDTO convertirADTO(LogSesionesEntity entidad) {
        LogSesionesDTO dto = new LogSesionesDTO();
        dto.setLogSesionCod(entidad.getLogSesionesCod());
        dto.setDia(entidad.getDia());
        dto.setUsuUsu(entidad.getUsuario().getUsuUsu());
        dto.setDisNom(entidad.getDispositivo().getDisNom());
        dto.setLogSesionEst(entidad.getLogSesionesEst());
        return dto;
    }



}
