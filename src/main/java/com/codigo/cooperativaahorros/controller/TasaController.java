package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.entity.TasaEntity;
import com.codigo.cooperativaahorros.request.TasaRequest;
import com.codigo.cooperativaahorros.service.TasaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/tasa")
@AllArgsConstructor
public class TasaController {

    private final TasaService tasaService;

    @PostMapping("/crear")
    public ResponseEntity<TasaEntity> registrar(@RequestBody TasaRequest tasaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tasaService.registrarTasa(tasaRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TasaEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tasaService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TasaEntity>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(tasaService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = tasaService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TasaEntity> actualizar(@RequestBody TasaRequest tasaRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tasaService.actualizar(tasaRequest, id));
    }

}
