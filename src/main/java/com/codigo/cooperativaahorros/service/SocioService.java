package com.codigo.cooperativaahorros.service;

import com.codigo.cooperativaahorros.dao.SocioRepository;
import com.codigo.cooperativaahorros.dto.SocioDTO;
import com.codigo.cooperativaahorros.entity.*;
import com.codigo.cooperativaahorros.request.SocioRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SocioService {

    private final SocioRepository socioRepository;
    private final CooperativaService cooperativaService;
    private final CuentaService cuentaService;
    private final DireccionService direccionService;

    @Transactional
    public SocioEntity registrarSocio(SocioRequest socioRequest) {
        SocioEntity entidad = new SocioEntity();
        entidad.setSocIden(socioRequest.getSocIden());
        entidad.setSocNom(socioRequest.getSocNom());
        entidad.setSocApePat(socioRequest.getSocApePat());
        entidad.setSocApeMat(socioRequest.getSocApeMat());
        entidad.setSocioFec(socioRequest.getSocioFec());
        entidad.setSocCor(socioRequest.getSocCor());
        entidad.setCuenta(cuentaService.buscarId(socioRequest.getCuenta()));
        entidad.setCooperativa(cooperativaService.buscarId(socioRequest.getCooperativa()));
        entidad.setDireccion(direccionService.buscarId(socioRequest.getDireccion()));
        entidad.setSocEst(socioRequest.getSocEst());
        return socioRepository.save(entidad);
    }

    @Transactional
    public SocioEntity buscarId(Long id) {
        return socioRepository.findById(id).orElseThrow(() -> new RuntimeException("Socio no encontrado"));
    }

    @Transactional
    public List<SocioDTO> buscarTodos() {
        return socioRepository.findAll().stream().map(this::convertirADTO).toList();
    }

    @Transactional
    public Map<Integer, String> buscarCodigos() {
        // Aquí simulando un mapa con códigos y nombres
        Map<Integer, String> codigosMap = new HashMap<>();
        buscarTodos().forEach(socio -> codigosMap.put(socio.getSocCod(), socio.getSocIden() + " - " + socio.getSocNom()));
        return codigosMap;
    }

    @Transactional
    public SocioEntity actualizar(SocioRequest socioRequest, Long id) {
        SocioEntity entidad = socioRepository.findById(id).orElseThrow(() -> new RuntimeException("Socio no encontrado"));
        entidad.setSocIden(socioRequest.getSocIden());
        entidad.setSocNom(socioRequest.getSocNom());
        entidad.setSocApePat(socioRequest.getSocApePat());
        entidad.setSocApeMat(socioRequest.getSocApeMat());
        entidad.setSocioFec(socioRequest.getSocioFec());
        entidad.setSocCor(socioRequest.getSocCor());
        entidad.setCuenta(cuentaService.buscarId(socioRequest.getCuenta()));
        entidad.setCooperativa(cooperativaService.buscarId(socioRequest.getCooperativa()));
        entidad.setDireccion(direccionService.buscarId(socioRequest.getDireccion()));
        entidad.setSocEst(socioRequest.getSocEst());
        return socioRepository.save(entidad);
    }

    private SocioDTO convertirADTO(SocioEntity entidad) {
        SocioDTO dto = new SocioDTO();
        dto.setSocCod(entidad.getSocCod().intValue());
        dto.setSocIden(entidad.getSocIden());
        dto.setSocApePat(entidad.getSocApePat());
        dto.setSocApeMat(entidad.getSocApeMat());
        dto.setSocNom(entidad.getSocNom());
        dto.setSocioFec(entidad.getSocioFec());
        dto.setSocCor(entidad.getSocCor());
        dto.setCooperativa(entidad.getCooperativa().getCooNom());
        dto.setCuenta(entidad.getCuenta().getCueNum().toString());
        String direccion = entidad.getDireccion().getDirDis() + " - " + entidad.getDireccion().getDirPro() + " - " + entidad.getDireccion().getDirDep();
        dto.setDireccion(direccion);
        dto.setSocEst(entidad.getSocEst());
        return dto;
    }

}
