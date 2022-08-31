package br.com.Logap.ProcessoSeletivo.tarefa2.controller;

import br.com.Logap.ProcessoSeletivo.tarefa2.model.entity.Fornecedor;
import br.com.Logap.ProcessoSeletivo.tarefa2.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin("*")
@Controller
@RequestMapping("/provider")
public class FornecedorController {

    @Autowired
    private FornecedorService providerService;

    @GetMapping(path = "/create")
    public String create(){
        return "createProvider";
    }

    @PostMapping
    public String newProvider(Fornecedor provider){
        providerService.newProvider(provider);
        return "redirect:/";
    }

    @GetMapping(path = "/all")
    public ModelAndView getProviders(){
        ModelAndView mv = new ModelAndView("listProvider");
        mv.addObject("providers",providerService.getProviders());
        return mv;
    }

    @GetMapping(path = "/outOfStock")
    public ModelAndView getOutOfStockProviders(){
        ModelAndView mv = new ModelAndView("listOutOfStockProviders");
        mv.addObject("providers",providerService.getOutOfStockProviders());
        return mv;
    }

    @GetMapping(path = "/edit/{id}") // Put
    public ModelAndView updateProvider(@PathVariable int id){
        ModelAndView mv = new ModelAndView("updateProvider");
        mv.addObject("provider", providerService.getProviderId(id));
        return mv;
    }

    @GetMapping(path = "/delete/{id}") // Delete
    public String deleteProvider(@PathVariable int id){
        providerService.deleteProvider(id);
        return "redirect:/";
    }

}
