package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.entity.DispositivoEntity;
import com.codigo.cooperativaahorros.request.DispositivoRequest;
import com.codigo.cooperativaahorros.service.DispositivoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/dispositivo")
@AllArgsConstructor
public class DispositivoController {

    private final DispositivoService dispositivoService;

    @PostMapping("/crear")
    public ResponseEntity<DispositivoEntity> registrar(@RequestBody DispositivoRequest dispositivoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dispositivoService.registrarDispositivo(dispositivoRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DispositivoEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(dispositivoService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<DispositivoEntity>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(dispositivoService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = dispositivoService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DispositivoEntity> actualizar(@RequestBody DispositivoRequest dispositivoRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(dispositivoService.actualizar(dispositivoRequest, id));
    }

}
