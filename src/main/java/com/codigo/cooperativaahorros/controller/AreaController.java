package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.entity.AreaEntity;
import com.codigo.cooperativaahorros.request.AreaRequest;
import com.codigo.cooperativaahorros.service.AreaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/area")
@AllArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @PostMapping("/crear")
    public ResponseEntity<AreaEntity> registrar(@RequestBody AreaRequest areaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(areaService.registrarArea(areaRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(areaService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<AreaEntity>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(areaService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = areaService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaEntity> actualizar(@RequestBody AreaRequest areaRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(areaService.actualizar(areaRequest, id));
    }

}
