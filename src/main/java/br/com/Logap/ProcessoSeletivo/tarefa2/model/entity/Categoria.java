package br.com.Logap.ProcessoSeletivo.tarefa2.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

    private int qtd_produtos;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "categoria") // "categoria" está em Produto
    private List<Produto> produtos;// feito para ter a relação bidirecional

    public Categoria() {

    }

    public Categoria(int id, String descricao, int qtd_produtos) {
        this.id = id;
        this.descricao = descricao;
        this.qtd_produtos = qtd_produtos;
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

    public int getQtd_produtos() {
        return qtd_produtos;
    }

    public void setQtd_produtos(int qtd_produtos) {
        this.qtd_produtos = qtd_produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
