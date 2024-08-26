package com.alcance.controle_estoque.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Entity
@Schema(description = "Representa um produto na loja")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do produto", example = "1")
    private Long id;

    @Schema(description = "Nome do produto", example = "Ração para Cachorros")
    private String nome;

    @Schema(description = "Descrição do produto", example = "Ração premium para cachorros adultos")
    private String descricao;

    @Schema(description = "Preço do produto", example = "99.90")
    private BigDecimal preco;

    // @Schema(description = "Quantidade disponível em estoque", example = "150")
    // private Integer quantidadeEmEstoque;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    @Schema(description = "Quantidade disponível em estoque em todas as unidades", example = "150")
    private List<EstoqueUnidade> estoqueUnidades;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    @Schema(description = "Categoria do produto")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    @Schema(description = "Fornecedor do produto")
    private Fornecedor fornecedor;
}
