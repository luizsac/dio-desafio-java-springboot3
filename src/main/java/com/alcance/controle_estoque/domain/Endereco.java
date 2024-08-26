package com.alcance.controle_estoque.domain;

import lombok.Data;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
public class Endereco {
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
}
