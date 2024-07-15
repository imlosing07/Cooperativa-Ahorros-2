package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.LogAccionesRepository;
import com.codigo.cooperativaahorros.dto.LogAccionesDTO;
import com.codigo.cooperativaahorros.dto.LogSesionesDTO;
import com.codigo.cooperativaahorros.entity.LogAccionesEntity;
import com.codigo.cooperativaahorros.request.LogAccionesRequest;
import com.codigo.cooperativaahorros.entity.LogSesionesEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@AllArgsConstructor
public class LogAccionesService {

    private final LogAccionesRepository logAccionesRepository;
    private final LogSesionesService logSesionesService;

    @Transactional
    public LogAccionesEntity registrarLogAcciones(LogAccionesRequest logAccionesRequest) {
        LogAccionesEntity entidad = new LogAccionesEntity();
        entidad.setHoraInicio(getTimeAsTime());
        entidad.setHoraFin(logAccionesRequest.getHoraFin());
        entidad.setLogSesionesCod(logSesionesService.buscarId(logAccionesRequest.getLogSesionesCod()));
        entidad.setLogSesionesEst('A');
        return logAccionesRepository.save(entidad);
    }

    @Transactional
    public LogAccionesEntity buscarId(Long id) {
        return logAccionesRepository.findById(id).orElseThrow(() -> new RuntimeException("Log de acciones no encontrado"));
    }

    @Transactional
    public List<Integer> buscarCodigos() {
        return buscarTodos().stream().map(LogAccionesDTO::getLogAccionesCod).toList();
    }

    @Transactional
    public List<LogAccionesDTO> buscarTodos() {
        return logAccionesRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Transactional
    public LogAccionesEntity actualizar(LogAccionesRequest logAccionesRequest, Long id) {
        LogAccionesEntity entidad = logAccionesRepository.findById(id).orElseThrow(() -> new RuntimeException("Log de acciones no encontrado"));
        entidad.setHoraFin(logAccionesRequest.getHoraFin());
        entidad.setLogSesionesCod(logSesionesService.buscarId(logAccionesRequest.getLogSesionesCod()));
        entidad.setLogSesionesEst(logAccionesRequest.getLogAccionEst());
        return logAccionesRepository.save(entidad);
    }

    private Time getTimeAsTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timeStr = sdf.format(timestamp);
        Time utilDate = Time.valueOf(timeStr);
        return new Time(utilDate.getTime());
    }

    private LogAccionesDTO convertirADTO(LogAccionesEntity entidad) {
        LogAccionesDTO dto = new LogAccionesDTO();
        dto.setLogAccionesCod(entidad.getLogAccionesCod().intValue());
        dto.setHoraInicio(entidad.getHoraInicio());
        dto.setHoraFin(entidad.getHoraFin());
        dto.setLogSesionCod(entidad.getLogSesionesCod().getLogSesionesCod().intValue());
        dto.setLogAccionEst(entidad.getLogSesionesEst());
        return dto;
    }

}
