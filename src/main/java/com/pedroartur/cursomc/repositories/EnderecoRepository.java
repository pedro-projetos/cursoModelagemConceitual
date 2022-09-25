package com.pedroartur.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedroartur.cursomc.domain.Endereco;

@Repository

public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {

}
