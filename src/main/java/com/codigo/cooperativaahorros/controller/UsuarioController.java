package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.UsuarioDTO;
import com.codigo.cooperativaahorros.entity.UsuarioEntity;
import com.codigo.cooperativaahorros.request.UsuarioRequest;
import com.codigo.cooperativaahorros.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<UsuarioEntity> registrar(@RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.registrarUsuario(usuarioRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<Map<Integer, String>> buscarCodigos() {
        Map<Integer, String> codigosMap = usuarioService.buscarCodigos();
        return ResponseEntity.status(HttpStatus.OK).body(codigosMap);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> actualizar(@RequestBody UsuarioRequest usuarioRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.actualizar(usuarioRequest, id));
    }

}
