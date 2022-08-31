package br.com.Logap.ProcessoSeletivo.tarefa2.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// sua própria sequencia de id.
    private int id;

    @NotBlank
    private String nome;

    @Min(0)
    private double valor;

    @Min(0)
    private long qtd_produto;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Fornecedor fornecedor;

    public Produto() {
    }

    public Produto(String nome, double valor, Categoria categoria, Fornecedor fornecedor) {
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getQtd_produto() {
        return qtd_produto;
    }

    public void setQtd_produto(long qtd_produto) {
        this.qtd_produto = qtd_produto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
