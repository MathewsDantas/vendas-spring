package br.com.Logap.ProcessoSeletivo.tarefa2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin("*")
@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public String home(){
        return "index";
    }
}
