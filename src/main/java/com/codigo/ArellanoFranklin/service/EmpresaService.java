package com.codigo.ArellanoFranklin.service;

import com.codigo.ArellanoFranklin.entity.EmpresaEntity;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {


    //crear
    EmpresaEntity crear(EmpresaEntity empresaEntity);
    //buscarxid
    Optional<EmpresaEntity> buscarxid(Long id);
    //buscarAll
    List<EmpresaEntity> buscarAll();
    //Actualizar
    EmpresaEntity actualizar(Long id,EmpresaEntity empresaEntity);
    //Borrar
    EmpresaEntity borrar(Long id);
}
