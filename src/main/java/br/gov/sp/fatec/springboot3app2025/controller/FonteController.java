package br.gov.sp.fatec.springboot3app2025.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.springboot3app2025.entity.Fonte;
import br.gov.sp.fatec.springboot3app2025.service.FonteService;

@RestController
@CrossOrigin
@RequestMapping(value = "/fonte")
public class FonteController {

    @Autowired
    private FonteService service;

    @GetMapping
    public List<Fonte> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/busca")
    public List<Fonte> buscarPorTituloEData(
            @RequestParam Integer potencia,
            @RequestParam String data) {
        LocalDate dataLancamento = LocalDate.parse(data);
        return service.buscarPorPotenciaEData(potencia, dataLancamento);
    }

    @PostMapping
    public Fonte cadastrar(@RequestBody Fonte fonte) {
        return service.cadastrar(fonte);
    }
    
}
