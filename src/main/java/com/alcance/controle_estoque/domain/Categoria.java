package com.alcance.controle_estoque.domain;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
}
