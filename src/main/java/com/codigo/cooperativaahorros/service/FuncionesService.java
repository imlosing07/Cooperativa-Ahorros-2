package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.CargoRepository;
import com.codigo.cooperativaahorros.dao.FuncionesRepository;
import com.codigo.cooperativaahorros.dto.FuncionesDTO;
import com.codigo.cooperativaahorros.entity.CargoEntity;
import com.codigo.cooperativaahorros.entity.FuncionesEntity;
import com.codigo.cooperativaahorros.entity.ManualEntity;
import com.codigo.cooperativaahorros.entity.RolEntity;
import com.codigo.cooperativaahorros.request.FuncionesRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FuncionesService {

    private final FuncionesRepository funcionesRepository;
    private final ManualService manualService;
    private final CargoService cargoService;

    @Transactional
    public FuncionesEntity registrarFunciones(FuncionesRequest funcionesRequest) {
        FuncionesEntity entidad = new FuncionesEntity();
        entidad.setFunDes(funcionesRequest.getFunDes());
        entidad.setFunReq(funcionesRequest.getFunReq());
        entidad.setManual(manualService.buscarId(funcionesRequest.getManual()));
        entidad.setCargo(cargoService.buscarId(funcionesRequest.getCargo()));
        entidad.setFunEst('A');
        funcionesRepository.save(entidad);
        entidad.getManual().getFunciones().add(entidad);
        entidad.getCargo().getFunciones().add(entidad);
        return entidad;
    }

    @Transactional
    public FuncionesEntity buscarId(Long id) {
        return funcionesRepository.findById(id).orElseThrow(() -> new RuntimeException("Funciones no encontradas"));
    }

    @Transactional
    public List<FuncionesDTO> buscarTodos() {
        return funcionesRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Transactional
    public Map<Long, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Long, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(funcion -> codigosMap.put(funcion.getFunCod(), funcion.getFunDes()));
        return codigosMap;
    }

    @Transactional
    public FuncionesEntity actualizar(FuncionesRequest funcionesRequest, Long id) {
        FuncionesEntity entidad = funcionesRepository.findById(id).orElseThrow(() -> new RuntimeException("Funciones no encontradas"));
        entidad.setFunDes(funcionesRequest.getFunDes());
        entidad.setFunReq(funcionesRequest.getFunReq());
        entidad.setManual(manualService.buscarId(funcionesRequest.getManual()));
        entidad.setCargo(cargoService.buscarId(funcionesRequest.getCargo()));
        entidad.setFunEst('A');
        funcionesRepository.save(entidad);
        entidad.getManual().getFunciones().add(entidad);
        entidad.getCargo().getFunciones().add(entidad);
        return entidad;
    }

    private FuncionesDTO convertirADTO(FuncionesEntity entidad) {
        FuncionesDTO dto = new FuncionesDTO();
        dto.setFunCod(entidad.getFunCod());
        dto.setFunDes(entidad.getFunDes());
        dto.setFunReq(entidad.getFunReq());
        dto.setManual(entidad.getManual().getManNom());
        dto.setCargo(entidad.getCargo().getCargoNom());
        dto.setFunEst(entidad.getFunEst());
        return dto;
    }

}
