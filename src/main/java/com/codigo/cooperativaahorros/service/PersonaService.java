package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.PersonaRepository;
import com.codigo.cooperativaahorros.dto.PersonaDTO;
import com.codigo.cooperativaahorros.entity.CargoEntity;
import com.codigo.cooperativaahorros.entity.PersonaEntity;
import com.codigo.cooperativaahorros.request.PersonaRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final CooperativaService cooperativaService;
    private final CargoService cargoService;

    @Transactional
    public PersonaEntity registrarPersona(PersonaRequest personaRequest) {
        PersonaEntity entidad = new PersonaEntity();
        entidad.setPerIden(personaRequest.getPerIden());
        entidad.setPerApePat(personaRequest.getPerApePat());
        entidad.setPerApeMat(personaRequest.getPerApeMat());
        entidad.setPerNom(personaRequest.getPerNom());
        entidad.setPerFecNac(personaRequest.getPerFecNac());
        entidad.setPerCor(personaRequest.getPerCor());
        entidad.setPerFot(personaRequest.getPerFot());
        //Guardando cooperativa
        entidad.setCooperativa(cooperativaService.buscarId(personaRequest.getCooperativa()));
        //Guardando el cargo
        CargoEntity cargo = cargoService.buscarId(personaRequest.getCargo());
        cargo.getPersonas().add(entidad);
        entidad.setCargo(cargo);

        entidad.setPerEst('A');
        return personaRepository.save(entidad);
    }

    @Transactional
    public PersonaEntity buscarId(Long id) {
        return personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Transactional
    public List<PersonaDTO> buscarTodos() {
        return personaRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Transactional
    public PersonaEntity actualizar(PersonaRequest personaRequest, Long id) {
        PersonaEntity entidad = personaRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        entidad.setPerIden(personaRequest.getPerIden());
        entidad.setPerApePat(personaRequest.getPerApePat());
        entidad.setPerApeMat(personaRequest.getPerApeMat());
        entidad.setPerNom(personaRequest.getPerNom());
        entidad.setPerFecNac(personaRequest.getPerFecNac());
        entidad.setPerCor(personaRequest.getPerCor());
        entidad.setPerFot(personaRequest.getPerFot());
        entidad.setCooperativa(cooperativaService.buscarId(personaRequest.getCooperativa()));
        entidad.setPerEst(personaRequest.getPerEst());
        return personaRepository.save(entidad);
    }

    private PersonaDTO convertirADTO(PersonaEntity entidad) {
        PersonaDTO dto = new PersonaDTO();
        dto.setPerCod(entidad.getPerCod().intValue());
        dto.setPerIden(entidad.getPerIden());
        dto.setPerApePat(entidad.getPerApePat());
        dto.setPerApeMat(entidad.getPerApeMat());
        dto.setPerNom(entidad.getPerNom());
        dto.setPerFecNac(entidad.getPerFecNac());
        dto.setPerCor(entidad.getPerCor());
        dto.setPerFot(entidad.getPerFot());
        dto.setCooNom(entidad.getCooperativa().getCooNom());
        dto.setCargoNom(entidad.getCargo().getCargoNom());
        dto.setPerEst(entidad.getPerEst());
        return dto;
    }

}
