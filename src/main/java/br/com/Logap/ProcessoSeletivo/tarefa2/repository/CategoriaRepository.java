package br.com.Logap.ProcessoSeletivo.tarefa2.repository;

import br.com.Logap.ProcessoSeletivo.tarefa2.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {

    @Query("SELECT c FROM Categoria c WHERE (c.id) = :id")
    Categoria searchByCategoryId(@Param("id") int id);

}
