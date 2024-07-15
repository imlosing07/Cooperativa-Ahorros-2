package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.AvanceDTO;
import com.codigo.cooperativaahorros.entity.AvanceEntity;
import com.codigo.cooperativaahorros.request.AvanceRequest;
import com.codigo.cooperativaahorros.service.AvanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/avance")
@AllArgsConstructor
public class AvanceController {

    private final AvanceService avanceService;

    @PostMapping("/crear")
    public ResponseEntity<AvanceEntity> registrar(@RequestBody AvanceRequest avanceRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(avanceService.registrarAvance(avanceRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvanceEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(avanceService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<AvanceDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(avanceService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvanceEntity> actualizar(@RequestBody AvanceRequest avanceRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(avanceService.actualizar(avanceRequest, id));
    }

}
