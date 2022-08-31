package br.com.Logap.ProcessoSeletivo.tarefa2.controller;

import br.com.Logap.ProcessoSeletivo.tarefa2.model.entity.Produto;
import br.com.Logap.ProcessoSeletivo.tarefa2.service.CategoriaService;
import br.com.Logap.ProcessoSeletivo.tarefa2.service.FornecedorService;
import br.com.Logap.ProcessoSeletivo.tarefa2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@CrossOrigin("*")
@Controller
@RequestMapping("/product")
public class ProdutoController {

    @Autowired
    private ProdutoService productService;
    @Autowired
    CategoriaService categoryService;
    @Autowired
    FornecedorService fornecedorService;

    @GetMapping(path = "/create")
    public ModelAndView create(){
        ModelAndView mv = new ModelAndView("createProduct");
        mv.addObject("categories", categoryService.getCategories());
        mv.addObject("providers", fornecedorService.getProviders());
        return mv;
    }

    @PostMapping
    public String newProduct(@Valid Produto product){
        productService.newProduct(product);
        return "redirect:/";
    }

    @GetMapping("/all")
    public ModelAndView getProducts(){
        ModelAndView mv = new ModelAndView("listProduct");
        mv.addObject("products",productService.getProducts());
        return mv;
    }

    @GetMapping(path = "/outOfStock")
    public ModelAndView getOutOfStockProducts(){
        ModelAndView mv = new ModelAndView("listOutOfStockProducts");
        mv.addObject("products",productService.getOutOfStockProducts());
        return mv;
    }

    @GetMapping("/edit/{id}")  //put
    public ModelAndView updateProduct(@PathVariable int id){
        ModelAndView mv = new ModelAndView("updateProduct");
        mv.addObject("product", productService.getProductId(id));
        mv.addObject("categories", categoryService.getCategories());
        mv.addObject("providers", fornecedorService.getProviders());
        return mv;
    }

    @GetMapping(path = "/delete/{id}") // Delete
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
