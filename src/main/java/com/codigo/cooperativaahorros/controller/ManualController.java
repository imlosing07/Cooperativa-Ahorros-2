package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.ManualDTO;
import com.codigo.cooperativaahorros.entity.ManualEntity;
import com.codigo.cooperativaahorros.request.ManualRequest;
import com.codigo.cooperativaahorros.service.ManualService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/manual")
@AllArgsConstructor
public class ManualController {

    private final ManualService manualService;

    @PostMapping("/crear")
    public ResponseEntity<ManualEntity> registrar(@RequestBody ManualRequest manualRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(manualService.registrarManual(manualRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManualEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(manualService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ManualDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(manualService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = manualService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManualEntity> actualizar(@RequestBody ManualRequest manualRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(manualService.actualizar(manualRequest, id));
    }

}
