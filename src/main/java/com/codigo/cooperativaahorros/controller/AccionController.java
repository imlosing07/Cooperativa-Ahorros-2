package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.AccionDTO;
import com.codigo.cooperativaahorros.entity.AccionEntity;
import com.codigo.cooperativaahorros.request.AccionRequest;
import com.codigo.cooperativaahorros.service.AccionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/accion")
@AllArgsConstructor
public class AccionController {

    private final AccionService accionService;

    @PostMapping("/crear")
    public ResponseEntity<AccionEntity> registrar(@RequestBody AccionRequest accionRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accionService.registrarAccion(accionRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccionEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(accionService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<AccionDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(accionService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccionEntity> actualizar(@RequestBody AccionRequest accionRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(accionService.actualizar(accionRequest, id));
    }

}
