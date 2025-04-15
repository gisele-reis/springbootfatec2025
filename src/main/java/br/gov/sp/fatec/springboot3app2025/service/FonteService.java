package br.gov.sp.fatec.springboot3app2025.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3app2025.entity.Fonte;
import br.gov.sp.fatec.springboot3app2025.repository.FonteRepository;

@Service
public class FonteService {

    @Autowired
    private FonteRepository repo;
    
    public List<Fonte> listarTodos() {
        return repo.findAll();
    }

    public List<Fonte> buscarPorPotenciaEData(Integer potencia, LocalDate data) {
        return repo.buscarPorPotenciaEData(potencia, data);
    }

    @Transactional
    public Fonte cadastrar(Fonte fonte) {
        if(fonte.getDescritivo() == null || fonte.getDescritivo().length() < 4) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Descritivo deve ter no mínimo 4 caracteres");
        }
        if (fonte.getPotenciaReal() != null && fonte.getPotenciaNominal() != null &&
            fonte.getPotenciaReal() > fonte.getPotenciaNominal()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Potência real não pode ser maior que a nominal.");
        }

        return repo.save(fonte);
    }
    
}
