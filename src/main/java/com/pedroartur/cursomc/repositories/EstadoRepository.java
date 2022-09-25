package com.pedroartur.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedroartur.cursomc.domain.Estado;

@Repository

public interface EstadoRepository extends JpaRepository <Estado, Integer> {

}
