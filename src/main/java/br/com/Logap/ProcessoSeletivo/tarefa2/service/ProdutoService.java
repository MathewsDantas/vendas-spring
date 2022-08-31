package br.com.Logap.ProcessoSeletivo.tarefa2.service;

import br.com.Logap.ProcessoSeletivo.tarefa2.model.entity.Produto;
import br.com.Logap.ProcessoSeletivo.tarefa2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository productRepository;

    public void newProduct(Produto product){
        if (product.getId() > 0){
            Produto productFind = getProductId(product.getId());
            productFind.setNome(product.getNome());
            productFind.setValor(product.getValor());
            productFind.setQtd_produto(product.getQtd_produto());
            productFind.setCategoria(product.getCategoria());
            productFind.setFornecedor(product.getFornecedor());
            updateProduct(productFind);
        }
        else {
            product.getCategoria().setQtd_produtos(product.getCategoria().getQtd_produtos()+1);
            productRepository.save(product);
        }
    }

    public Iterable<Produto> getProducts(){
        return productRepository.findAll();
    }

    public Produto getProductId(int id){
        return productRepository.searchByProductId(id);
    }

    public Iterable<Produto> getOutOfStockProducts(){
        return productRepository.getOutOfStockProducts();
    }

    public void updateProduct(Produto product){
        productRepository.save(product);
    }

    public void deleteProduct(int id){
        Produto productFind = getProductId(id);
        productFind.getCategoria().setQtd_produtos(productFind.getCategoria().getQtd_produtos() -1);
        productRepository.deleteById(id);
    }
}
