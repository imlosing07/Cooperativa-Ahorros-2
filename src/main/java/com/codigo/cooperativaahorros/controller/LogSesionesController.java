package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.LogSesionesDTO;
import com.codigo.cooperativaahorros.entity.LogSesionesEntity;
import com.codigo.cooperativaahorros.request.LogSesionesRequest;
import com.codigo.cooperativaahorros.service.LogSesionesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/logSesiones")
@AllArgsConstructor
public class LogSesionesController {

    private final LogSesionesService logSesionesService;

    @PostMapping("/crear")
    public ResponseEntity<LogSesionesEntity> registrar(@RequestBody LogSesionesRequest logSesionesRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(logSesionesService.registrarLogSesiones(logSesionesRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogSesionesEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(logSesionesService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<LogSesionesDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(logSesionesService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<List<Long>> buscarCodigos() {
        return ResponseEntity.status(HttpStatus.OK).body(logSesionesService.buscarCodigos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogSesionesEntity> actualizar(@RequestBody LogSesionesRequest logSesionesRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(logSesionesService.actualizar(logSesionesRequest, id));
    }

}
