package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.PersonaDTO;
import com.codigo.cooperativaahorros.entity.PersonaEntity;
import com.codigo.cooperativaahorros.request.PersonaRequest;
import com.codigo.cooperativaahorros.service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/persona")
@AllArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping("/crear")
    public ResponseEntity<PersonaEntity> registrar(@RequestBody PersonaRequest personaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.registrarPersona(personaRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(personaService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PersonaDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(personaService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaEntity> actualizar(@RequestBody PersonaRequest personaRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(personaService.actualizar(personaRequest, id));
    }

}

