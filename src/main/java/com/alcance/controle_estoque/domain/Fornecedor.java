package com.alcance.controle_estoque.domain;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String telefone;
    private String email;

    @Embedded
    private Endereco endereco;
}
