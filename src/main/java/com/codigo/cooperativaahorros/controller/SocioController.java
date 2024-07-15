package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.SocioDTO;
import com.codigo.cooperativaahorros.entity.SocioEntity;
import com.codigo.cooperativaahorros.request.SocioRequest;
import com.codigo.cooperativaahorros.service.SocioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/socio")
@AllArgsConstructor
public class SocioController {

    private final SocioService socioService;

    @PostMapping("/crear")
    public ResponseEntity<SocioEntity> registrar(@RequestBody SocioRequest socioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(socioService.registrarSocio(socioRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(socioService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<SocioDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(socioService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = socioService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioEntity> actualizar(@RequestBody SocioRequest socioRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(socioService.actualizar(socioRequest, id));
    }

}
