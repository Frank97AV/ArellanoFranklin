package com.codigo.ArellanoFranklin.service.impl;

import com.codigo.ArellanoFranklin.contans.Constans;
import com.codigo.ArellanoFranklin.dao.EmpresaRepository;
import com.codigo.ArellanoFranklin.entity.EmpresaEntity;
import com.codigo.ArellanoFranklin.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Constants;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;


    @Override
    public EmpresaEntity crear(EmpresaEntity empresaEntity) {
        empresaEntity.setEstado(Constans.ESTADO);
        empresaEntity.setUsuaCrea(Constans.USU);
        empresaEntity.setDateCreate(getTimestamp());
        return empresaRepository.save(empresaEntity);
    }

    @Override
    public Optional<EmpresaEntity> buscarxid(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<EmpresaEntity> buscarAll() {
        return empresaRepository.findAll();
    }

    @Override
    public EmpresaEntity actualizar(Long id, EmpresaEntity empresaEntity) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if (empresaRecuperada.isPresent()) {
            EmpresaEntity empresa = empresaRecuperada.get();
            empresa.setRazonSocial(empresaEntity.getRazonSocial());
            empresa.setTipoDocumento(empresaEntity.getTipoDocumento());
            empresa.setNumeroDocumento(empresaEntity.getNumeroDocumento());
            empresa.setCondicion(empresaEntity.getCondicion());
            empresa.setDireccion(empresaEntity.getDireccion());
            empresa.setDistrito(empresaEntity.getDistrito());
            empresa.setProvincia(empresaEntity.getProvincia());
            empresa.setDepartamento(empresaEntity.getDepartamento());
            empresa.setEsAgenteRetencion(empresaEntity.isEsAgenteRetencion());
            empresa.setEstado(Constans.ESTADO);
            //empresa.setUsuaCrea(empresaEntity.getUsuaCrea());
            //empresa.setDateCreate(empresaEntity.getDateCreate());
            empresa.setUsuaModif(Constans.USU);
            empresa.setDateModif(getTimestamp());
            //empresa.setUsuaDelete(empresaEntity.getUsuaDelete());
            //empresa.setDateDelete(empresaEntity.getDateDelete());
            return empresaRepository.save(empresa);
        }
        return null;
    }

    @Override
    public EmpresaEntity borrar(Long id) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if (empresaRecuperada.isPresent()) {
            EmpresaEntity empresa = empresaRecuperada.get();
            empresaRecuperada.get().setEstado(0);
            empresaRecuperada.get().setUsuaDelete(Constans.USU);
            empresaRecuperada.get().setDateDelete(getTimestamp());
            return empresaRepository.save(empresa);
        }
        return null;
    }
    private Timestamp getTimestamp(){
        long currenTIme = System.currentTimeMillis();
        return new Timestamp(currenTIme);
    }
}
