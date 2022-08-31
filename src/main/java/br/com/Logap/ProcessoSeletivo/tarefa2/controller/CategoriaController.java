package br.com.Logap.ProcessoSeletivo.tarefa2.controller;

import br.com.Logap.ProcessoSeletivo.tarefa2.model.entity.Categoria;
import br.com.Logap.ProcessoSeletivo.tarefa2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@CrossOrigin("*")
@Controller
@RequestMapping("/category")
public class CategoriaController {

    @Autowired
    private CategoriaService categoryService;

    @GetMapping(path = "/create")
    public String create(){
        return "createCategory";
    }

    @PostMapping
    public String newCategory(Categoria category){
        categoryService.newCategory(category);
        return "redirect:/";
    }

    @GetMapping(path = "/all")
    public ModelAndView getCategories(){
        ModelAndView mv = new ModelAndView("listCategory");
        mv.addObject("categories",categoryService.getCategories());
        return mv;
    }

    @GetMapping(path = "/edit/{id}") // Put
    public ModelAndView updateCategory(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("updateCategory");
        mv.addObject("category", categoryService.getCategoryId(id));
        return mv;
    }

    @GetMapping(path = "/delete/{id}") // Delete
    public String deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
        return "redirect:/";
    }
}
