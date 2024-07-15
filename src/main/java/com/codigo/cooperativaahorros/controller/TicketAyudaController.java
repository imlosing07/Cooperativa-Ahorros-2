package com.codigo.cooperativaahorros.controller;

import com.codigo.cooperativaahorros.dto.TicketAyudaDTO;
import com.codigo.cooperativaahorros.entity.TicketAyudaEntity;
import com.codigo.cooperativaahorros.request.TicketAyudaRequest;
import com.codigo.cooperativaahorros.service.TicketAyudaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/ticketAyuda")
@AllArgsConstructor
public class TicketAyudaController {

    private final TicketAyudaService ticketAyudaService;

    @PostMapping("/crear")
    public ResponseEntity<TicketAyudaEntity> registrar(@RequestBody TicketAyudaRequest ticketAyudaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketAyudaService.registrarTicket(ticketAyudaRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketAyudaEntity> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketAyudaService.buscarId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TicketAyudaDTO>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(ticketAyudaService.buscarTodos());
    }

    @GetMapping("/codigos")
    public ResponseEntity<List<Integer>> buscarCodigos() {
        return ResponseEntity.status(HttpStatus.OK).body(ticketAyudaService.buscarCodigos());
    }



    @PutMapping("/{id}")
    public ResponseEntity<TicketAyudaEntity> actualizar(@RequestBody TicketAyudaRequest ticketAyudaRequest, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketAyudaService.actualizar(ticketAyudaRequest, id));
    }

}
