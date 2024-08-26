package com.alcance.controle_estoque.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
@Schema(description = "Representa uma das unidades das lojas na cidade")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único da unidade", example = "1")
    private Long id;

    @Schema(description = "Nome da unidade", example = "Loja do Centro")
    private String nome;

    @Schema(description = "Cidade onde a loja está localizada", example = "Lavras")
    private String cidade;

    @Schema(description = "Estado onde a loja está localizada", example = "Minas Gerais")
    private String estado;

    @Schema(description = "Endereço da loja", example = "Rua Chagas Dória, 483 - Centro")
    private String endereco;

    @OneToMany(mappedBy = "unidade", cascade = CascadeType.ALL)
    @Schema(description = "Quantidade disponível em estoque em todas as unidades", example = "150")
    private List<EstoqueUnidade> estoqueUnidades;

}
