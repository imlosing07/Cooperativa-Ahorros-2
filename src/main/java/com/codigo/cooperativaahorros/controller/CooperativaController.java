package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.CooperativaDTO;
import com.codigo.cooperativaahorros.entity.CooperativaEntity;
import com.codigo.cooperativaahorros.request.CooperativaRequest;
import com.codigo.cooperativaahorros.service.CooperativaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/cooperativa")
@AllArgsConstructor
public class CooperativaController {

    private final CooperativaService cooperativaService;
    @PostMapping("/crear")
    public ResponseEntity<CooperativaEntity> registrar(@RequestBody CooperativaRequest cooperativaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cooperativaService.registarCooperativa(cooperativaRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CooperativaEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cooperativaService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<CooperativaDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.CREATED).body(cooperativaService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = cooperativaService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CooperativaEntity> actualizar(@RequestBody CooperativaRequest cooperativaRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cooperativaService.actualizar(cooperativaRequest, id));
    }



}
