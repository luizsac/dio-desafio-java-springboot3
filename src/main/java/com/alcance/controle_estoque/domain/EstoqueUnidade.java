package com.alcance.controle_estoque.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class EstoqueUnidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do estoque por unidade", example = "1")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Unidade unidade;

    @Schema(description = "Quantidade de unidades do produto disponíveis na unidade", example = "35")
    private Integer quantidade;

}
