package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.entity.CuentaEntity;
import com.codigo.cooperativaahorros.request.CuentaRequest;
import com.codigo.cooperativaahorros.service.CuentaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/cuenta")
@AllArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;

    @PostMapping("/crear")
    public ResponseEntity<CuentaEntity> registrar(@RequestBody CuentaRequest cuentaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaService.registrarCuenta(cuentaRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuentaEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cuentaService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<CuentaEntity>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(cuentaService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = cuentaService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaEntity> actualizar(@RequestBody CuentaRequest cuentaRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cuentaService.actualizar(cuentaRequest, id));
    }

}
