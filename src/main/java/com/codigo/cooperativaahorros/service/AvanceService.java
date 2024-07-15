package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.AvanceRepository;
import com.codigo.cooperativaahorros.dao.TicketAyudaRepository;
import com.codigo.cooperativaahorros.dto.AvanceDTO;
import com.codigo.cooperativaahorros.entity.AvanceEntity;
import com.codigo.cooperativaahorros.entity.TicketAyudaEntity;
import com.codigo.cooperativaahorros.request.AvanceRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AvanceService {

    private final AvanceRepository avanceRepository;
    private final TicketAyudaRepository ticketAyudaRepository;

    @Transactional
    public AvanceEntity registrarAvance(AvanceRequest avanceRequest) {
        AvanceEntity entidad = new AvanceEntity();
        entidad.setAvaDes(avanceRequest.getAvaDes());
        entidad.setDuda(avanceRequest.getDuda());
        entidad.setAvaFec(avanceRequest.getAvaFec());
        TicketAyudaEntity ticketAyuda = ticketAyudaRepository.findById(avanceRequest.getTicketAyuda())
                .orElseThrow(() -> new RuntimeException("Ticket de ayuda no encontrado"));
        entidad.setTicketAyuda(ticketAyuda);
        entidad.setAvaEst('A');
        return avanceRepository.save(entidad);
    }

    @Transactional
    public AvanceEntity buscarId(Long id) {
        return avanceRepository.findById(id).orElseThrow(() -> new RuntimeException("Avance no encontrado"));
    }

    @Transactional
    public List<AvanceDTO> buscarTodos() {
        return avanceRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Transactional
    public AvanceEntity actualizar(AvanceRequest avanceRequest, Long id) {
        AvanceEntity entidad = avanceRepository.findById(id).orElseThrow(() -> new RuntimeException("Avance no encontrado"));
        entidad.setAvaDes(avanceRequest.getAvaDes());
        entidad.setDuda(avanceRequest.getDuda());
        entidad.setAvaFec(avanceRequest.getAvaFec());
        TicketAyudaEntity ticketAyuda = ticketAyudaRepository.findById(avanceRequest.getTicketAyuda())
                .orElseThrow(() -> new RuntimeException("Ticket de ayuda no encontrado"));
        entidad.setTicketAyuda(ticketAyuda);
        entidad.setAvaEst(avanceRequest.getAvaEst());
        return avanceRepository.save(entidad);
    }

    private AvanceDTO convertToDto(AvanceEntity avanceEntity) {
        AvanceDTO avanceDTO = new AvanceDTO();
        avanceDTO.setAvaCod(avanceEntity.getAvaCod().intValue());
        avanceDTO.setAvaDes(avanceEntity.getAvaDes());
        avanceDTO.setDuda(avanceEntity.getDuda());
        avanceDTO.setAvaFec(avanceEntity.getAvaFec());
        avanceDTO.setTicketAyudaCod(avanceEntity.getTicketAyuda().getTicketCod().intValue());
        avanceDTO.setAvaEst(avanceEntity.getAvaEst());
        return avanceDTO;
    }

}
