package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.entity.SolucionEntity;
import com.codigo.cooperativaahorros.request.SolucionRequest;
import com.codigo.cooperativaahorros.service.SolucionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/solucion")
@AllArgsConstructor
public class SolucionController {

    private final SolucionService solucionService;

    @PostMapping("/crear")
    public ResponseEntity<SolucionEntity> registrar(@RequestBody SolucionRequest solucionRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solucionService.registrarSolucion(solucionRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolucionEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(solucionService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<SolucionEntity>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(solucionService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = solucionService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolucionEntity> actualizar(@RequestBody SolucionRequest solucionRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(solucionService.actualizar(solucionRequest, id));
    }

}
