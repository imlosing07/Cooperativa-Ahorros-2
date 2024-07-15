package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.RolDTO;
import com.codigo.cooperativaahorros.entity.RolEntity;
import com.codigo.cooperativaahorros.request.RolRequest;
import com.codigo.cooperativaahorros.service.RolService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/rol")
@AllArgsConstructor
public class RolController {

    private final RolService rolService;

    @PostMapping("/crear")
    public ResponseEntity<RolEntity> registrar(@RequestBody RolRequest rolRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.registrarRol(rolRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(rolService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<RolDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(rolService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        return ResponseEntity.status(HttpStatus.OK).body(rolService.buscarCodigos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolEntity> actualizar(@RequestBody RolRequest rolRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(rolService.actualizar(rolRequest, id));
    }

}
