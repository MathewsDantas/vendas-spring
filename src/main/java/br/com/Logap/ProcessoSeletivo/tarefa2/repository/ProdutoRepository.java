package br.com.Logap.ProcessoSeletivo.tarefa2.repository;

import br.com.Logap.ProcessoSeletivo.tarefa2.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto,Integer>{

    @Query("SELECT p FROM Produto p WHERE (p.id) = :id")
    Produto searchByProductId(@Param("id") int id);

    @Query("SELECT p FROM Produto p WHERE (p.qtd_produto) = 0")
    Iterable<Produto> getOutOfStockProducts();
}
