package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.ProductoDTO;
import com.codigo.cooperativaahorros.entity.ProductoEntity;
import com.codigo.cooperativaahorros.request.ProductoRequest;
import com.codigo.cooperativaahorros.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/producto")
@AllArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<ProductoEntity> registrar(@RequestBody ProductoRequest productoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.registrarProducto(productoRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<ProductoDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoEntity> actualizar(@RequestBody ProductoRequest productoRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.actualizar(productoRequest, id));
    }

}
