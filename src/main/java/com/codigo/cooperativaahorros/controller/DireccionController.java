package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.DireccionDTO;
import com.codigo.cooperativaahorros.entity.DireccionEntity;
import com.codigo.cooperativaahorros.request.DireccionRequest;
import com.codigo.cooperativaahorros.service.DireccionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/direccion")
@AllArgsConstructor
public class DireccionController {

    private final DireccionService direccionService;

    @PostMapping("/crear")
    public ResponseEntity<DireccionEntity> registrar(@RequestBody DireccionRequest direccionRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(direccionService.registrarDireccion(direccionRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(direccionService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<DireccionDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(direccionService.buscarTodos());
    }
    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = direccionService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DireccionEntity> actualizar(@RequestBody DireccionRequest direccionRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(direccionService.actualizar(direccionRequest, id));
    }

}
