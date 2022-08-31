package br.com.Logap.ProcessoSeletivo.tarefa2.repository;

import br.com.Logap.ProcessoSeletivo.tarefa2.model.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    @Query("SELECT f FROM Fornecedor f WHERE (f.id) = :id")
    Fornecedor searchByProviderId(@Param("id") int id);

    @Query(" SELECT DISTINCT f FROM Fornecedor f JOIN Produto p ON p.fornecedor.id = f.id WHERE p.qtd_produto = 0 ")
    Iterable<Fornecedor> getOutOfStockProviders();
}
