package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.SolucionRepository;
import com.codigo.cooperativaahorros.dao.TicketAyudaRepository;
import com.codigo.cooperativaahorros.dto.LogSesionesDTO;
import com.codigo.cooperativaahorros.dto.TicketAyudaDTO;
import com.codigo.cooperativaahorros.entity.TicketAyudaEntity;
import com.codigo.cooperativaahorros.request.TicketAyudaRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TicketAyudaService {

    private final TicketAyudaRepository ticketAyudaRepository;
    private final UsuarioService usuarioService;
    private final AreaService areaService;
    private final SolucionRepository solucionRepository;

    @Transactional
    public TicketAyudaEntity registrarTicket(TicketAyudaRequest ticketAyudaRequest) {
        TicketAyudaEntity entidad = new TicketAyudaEntity();
        entidad.setDescripcion(ticketAyudaRequest.getDescripcion());
        entidad.setFechaCreacion(getDate());
        entidad.setUsuario(usuarioService.buscarId(ticketAyudaRequest.getUsuario()));
        entidad.setTipSer(ticketAyudaRequest.getTipSer());
        entidad.setAreCod(areaService.buscarId(ticketAyudaRequest.getAreCod()));
        entidad.setSoluciones(ticketAyudaRequest.getSoluciones().stream().map(solucion -> new SolucionService(solucionRepository).buscarId(solucion)).collect(Collectors.toList()));
        entidad.setEstCod(ticketAyudaRequest.getEstCod());
        return ticketAyudaRepository.save(entidad);
    }

    @Transactional
    public TicketAyudaEntity buscarId(Long id) {
        return ticketAyudaRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
    }

    @Transactional
    public List<TicketAyudaDTO> buscarTodos() {
        return ticketAyudaRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public List<Integer> buscarCodigos() {
        return buscarTodos().stream().map(TicketAyudaDTO::getTicketCod).toList();
    }

    @Transactional
    public TicketAyudaEntity actualizar(TicketAyudaRequest ticketAyudaRequest, Long id) {
        TicketAyudaEntity entidad = ticketAyudaRepository.findById(id).orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        entidad.setDescripcion(ticketAyudaRequest.getDescripcion());
        entidad.setFechaCreacion(ticketAyudaRequest.getFechaCreacion());
        entidad.setUsuario(usuarioService.buscarId(ticketAyudaRequest.getUsuario()));
        entidad.setTipSer(ticketAyudaRequest.getTipSer());
        entidad.setAreCod(areaService.buscarId(ticketAyudaRequest.getAreCod()));
        entidad.setSoluciones(ticketAyudaRequest.getSoluciones().stream().map(solucion -> new SolucionService(solucionRepository).buscarId(solucion)).collect(Collectors.toList()));
        entidad.setEstCod(ticketAyudaRequest.getEstCod());
        return ticketAyudaRepository.save(entidad);
    }

    private Date getDate() {
        return new Date(System.currentTimeMillis());
    }

    private TicketAyudaDTO toDTO(TicketAyudaEntity entity) {
        TicketAyudaDTO dto = new TicketAyudaDTO();
        dto.setTicketCod(entity.getTicketCod().intValue());
        dto.setDescripcion(entity.getDescripcion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuUsu(entity.getUsuario().getUsuUsu());
        dto.setTipSer(entity.getTipSer());
        dto.setAreNom(entity.getAreCod().getAreNom());
        dto.setSoluciones(entity.getSoluciones().stream().map(solucion -> solucion.getSolNom().toString()).collect(Collectors.joining(",")));
        dto.setEstCod(entity.getEstCod());
        return dto;
    }

}
