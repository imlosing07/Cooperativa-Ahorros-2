package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.FuncionesDTO;
import com.codigo.cooperativaahorros.entity.FuncionesEntity;
import com.codigo.cooperativaahorros.request.FuncionesRequest;
import com.codigo.cooperativaahorros.service.FuncionesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/funciones")
@AllArgsConstructor
public class FuncionesController {

    private final FuncionesService funcionesService;

    @PostMapping("/crear")
    public ResponseEntity<FuncionesEntity> registrar(@RequestBody FuncionesRequest funcionesRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionesService.registrarFunciones(funcionesRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionesEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionesService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<FuncionesDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionesService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Long, String>> buscarCodigos() {
        Map<Long, String> codigosMap = funcionesService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionesEntity> actualizar(@RequestBody FuncionesRequest funcionesRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionesService.actualizar(funcionesRequest, id));
    }

}
