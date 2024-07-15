package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.entity.MonedaEntity;
import com.codigo.cooperativaahorros.request.MonedaRequest;
import com.codigo.cooperativaahorros.service.MonedaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/moneda")
@AllArgsConstructor
public class MonedaController {

    private final MonedaService monedaService;

    @PostMapping("/crear")
    public ResponseEntity<MonedaEntity> registrar(@RequestBody MonedaRequest monedaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monedaService.registrarMoneda(monedaRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonedaEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(monedaService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<MonedaEntity>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(monedaService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = monedaService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonedaEntity> actualizar(@RequestBody MonedaRequest monedaRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(monedaService.actualizar(monedaRequest, id));
    }

}
