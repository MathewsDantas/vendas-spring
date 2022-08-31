package br.com.Logap.ProcessoSeletivo.tarefa2.service;

import br.com.Logap.ProcessoSeletivo.tarefa2.model.entity.Fornecedor;
import br.com.Logap.ProcessoSeletivo.tarefa2.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository providerRepository;

    public void newProvider(Fornecedor provider){
        if (provider.getId() > 0){
            Fornecedor providerFind = getProviderId(provider.getId());
            providerFind.setDescricao(provider.getDescricao());
            updateProvider(provider);
        }
        else {
            providerRepository.save(provider);
        }

    }

    public Iterable<Fornecedor> getProviders(){
        return providerRepository.findAll();
    }

    public Fornecedor getProviderId(int id){
        return providerRepository.searchByProviderId(id);
    }

    public Iterable<Fornecedor> getOutOfStockProviders(){
        return providerRepository.getOutOfStockProviders();
    }

    public void updateProvider(Fornecedor provider){
        providerRepository.save(provider);
    }

    public void deleteProvider(int id){
        providerRepository.deleteById(id);
    }
}
