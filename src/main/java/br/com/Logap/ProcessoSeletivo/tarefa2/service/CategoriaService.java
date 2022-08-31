package br.com.Logap.ProcessoSeletivo.tarefa2.service;

import br.com.Logap.ProcessoSeletivo.tarefa2.model.entity.Categoria;
import br.com.Logap.ProcessoSeletivo.tarefa2.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoryRepository;

    public void newCategory(Categoria category){
        if (category.getId() > 0){
            Categoria categoryFind = getCategoryId(category.getId());
            categoryFind.setDescricao(category.getDescricao());
            updateCategory(categoryFind);
        }
        else {
            categoryRepository.save(category);
        }
    }

    public Iterable<Categoria> getCategories(){
        return categoryRepository.findAll();
    }

    public Categoria getCategoryId(int id){
        return categoryRepository.searchByCategoryId(id);
    }

    public void updateCategory(Categoria category){
        categoryRepository.save(category);
    }

    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }

}
