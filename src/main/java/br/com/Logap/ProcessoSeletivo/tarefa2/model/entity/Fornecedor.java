package br.com.Logap.ProcessoSeletivo.tarefa2.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String descricao;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "fornecedor")
    private List<Produto> produtos;

    public Fornecedor() {
    }

    public Fornecedor(String descricao, List<Produto> produtos) {
        this.descricao = descricao;
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
