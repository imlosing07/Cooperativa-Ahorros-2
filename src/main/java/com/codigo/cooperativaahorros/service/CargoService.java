package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.CargoRepository;
import com.codigo.cooperativaahorros.dao.FuncionesRepository;
import com.codigo.cooperativaahorros.dao.PersonaRepository;
import com.codigo.cooperativaahorros.dto.CargoDTO;
import com.codigo.cooperativaahorros.dto.PersonaDTO;
import com.codigo.cooperativaahorros.entity.CargoEntity;
import com.codigo.cooperativaahorros.entity.FuncionesEntity;
import com.codigo.cooperativaahorros.entity.PersonaEntity;
import com.codigo.cooperativaahorros.request.CargoRequest;
import com.codigo.cooperativaahorros.request.PersonaRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CargoService {

    private final CargoRepository cargoRepository;

    private final FuncionesRepository funcionesRepository;

    private final PersonaRepository personaRepository;

    @Transactional
    public CargoEntity registrarCargo(CargoRequest cargoRequest) {
        CargoEntity entidad = new CargoEntity();
        entidad.setCargoNom(cargoRequest.getCarNom());
        entidad.setCargoDes(cargoRequest.getCargoDes());
        entidad.setCargoEst('A');
        return cargoRepository.save(entidad);
    }

    @Transactional
    public CargoEntity buscarId(Long id) {
        return cargoRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Transactional
    public List<CargoDTO> buscarTodos() {
        return cargoRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Transactional
    public CargoEntity actualizar(CargoRequest cargoRequest, Long id) {
        CargoEntity entidad = cargoRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        entidad.setCargoNom(cargoRequest.getCarNom());
        entidad.setCargoDes(cargoRequest.getCargoDes());
        entidad.setCargoEst('A');
        return cargoRepository.save(entidad);
    }

    private CargoDTO convertirADTO(CargoEntity entidad) {
        CargoDTO dto = new CargoDTO();
        dto.setCargoCod(entidad.getCargoCod());
        dto.setCargoNom(entidad.getCargoNom());
        dto.setCargoDes(entidad.getCargoDes());

        // Convertir las descripciones de funciones a una lista de strings y unirlas en un solo string
        String funciones = entidad.getFunciones().stream().map(FuncionesEntity::getFunDes).collect(Collectors.joining(", "));
        dto.setFunciones(funciones);

        // Convertir los nombres de personas a una lista de strings y unirlas en un solo string
        String personas = entidad.getPersonas().stream().map(PersonaEntity::getPerNom).collect(Collectors.joining(", "));
        dto.setPersonas(personas);

        dto.setCargoEst(entidad.getCargoEst());
        return dto;
    }
}