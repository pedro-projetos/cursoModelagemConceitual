package com.pedroartur.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedroartur.cursomc.domain.Pagamento;

@Repository

public interface PagamentoRepository extends JpaRepository <Pagamento, Integer> {

}
