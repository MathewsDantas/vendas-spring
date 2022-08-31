package br.com.Logap.ProcessoSeletivo.tarefa1.controller;

import br.com.Logap.ProcessoSeletivo.tarefa1.model.Text;
import br.com.Logap.ProcessoSeletivo.tarefa1.service.VowelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vowel")
public class VowelController {

    @Autowired
    private VowelService vowelService;

    @GetMapping("/{stream}")
    public Text searchAfterNon_RepeatedConsonant(@PathVariable String stream)
    {
        return vowelService.searchAfterNon_RepeatedConsonant(stream);
    }
}
