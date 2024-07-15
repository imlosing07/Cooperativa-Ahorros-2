package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.LogAccionesDTO;
import com.codigo.cooperativaahorros.entity.LogAccionesEntity;
import com.codigo.cooperativaahorros.request.LogAccionesRequest;
import com.codigo.cooperativaahorros.service.LogAccionesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/logAcciones")
@AllArgsConstructor
public class LogAccionesController {

    private final LogAccionesService logAccionesService;

    @PostMapping("/crear")
    public ResponseEntity<LogAccionesEntity> registrar(@RequestBody LogAccionesRequest logAccionesRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(logAccionesService.registrarLogAcciones(logAccionesRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogAccionesEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(logAccionesService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<LogAccionesDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(logAccionesService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<List<Integer>> buscarCodigos() {
        return ResponseEntity.status(HttpStatus.OK).body(logAccionesService.buscarCodigos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogAccionesEntity> actualizar(@RequestBody LogAccionesRequest logAccionesRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(logAccionesService.actualizar(logAccionesRequest, id));
    }

}
