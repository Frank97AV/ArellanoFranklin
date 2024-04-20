package com.codigo.ArellanoFranklin.dao;

import com.codigo.ArellanoFranklin.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
