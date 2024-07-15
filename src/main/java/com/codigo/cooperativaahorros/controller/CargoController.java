package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.CargoDTO;
import com.codigo.cooperativaahorros.entity.CargoEntity;
import com.codigo.cooperativaahorros.request.CargoRequest;
import com.codigo.cooperativaahorros.service.CargoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/cargo")
@AllArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @PostMapping("/crear")
    public ResponseEntity<CargoEntity> registrar(@RequestBody CargoRequest cargoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.registrarCargo(cargoRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<CargoDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Long, String>> buscarCodigos() {
        Map<Long, String> codigosMap = cargoService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoEntity> actualizar(@RequestBody CargoRequest cargoRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.actualizar(cargoRequest, id));
    }

}
