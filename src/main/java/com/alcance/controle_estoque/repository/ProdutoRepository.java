package com.alcance.controle_estoque.repository;

import com.alcance.controle_estoque.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
