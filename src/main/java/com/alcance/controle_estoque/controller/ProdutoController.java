package com.alcance.controle_estoque.controller;

import com.alcance.controle_estoque.domain.Produto;
import com.alcance.controle_estoque.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@Tag(name = "Produtos", description = "API para gerenciamento de produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista de todos os produtos")
    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @Operation(summary = "Criar um novo produto", description = "Adiciona um novo produto ao estoque")
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        // produto.setQuantidadeEmEstoque(produtoAtualizado.getQuantidadeEmEstoque());
        produto.setEstoqueUnidades(produtoAtualizado.getEstoqueUnidades());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setFornecedor(produtoAtualizado.getFornecedor());
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
