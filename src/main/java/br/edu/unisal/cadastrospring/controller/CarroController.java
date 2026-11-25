package br.edu.unisal.cadastrospring.controller;

import br.edu.unisal.cadastrospring.domain.Carro;
import br.edu.unisal.cadastrospring.repos.CarroRepository;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class CarroController {
    private final CarroRepository repo;

    public CarroController(CarroRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/carros")
    public List<Carro> listar(){ return repo.findAll(); }

    @GetMapping("/carros/{id}")
    public Carro listarPorId(@PathVariable Long id) {
         return repo.findById(id).orElse(new Carro());
    }

    @PostMapping("/carros")
    @ResponseStatus(HttpStatus.CREATED)
    public Carro salvar(@Valid @RequestBody Carro carro){
        carro.setId(null);
        return repo.save(carro);
    }

    @PutMapping("/carros/{id}")
    public Carro editar(@PathVariable Long id,
        @Valid @RequestBody Carro carro){
        carro.setId(id);
        return repo.save(carro);
    }

    @DeleteMapping("/carros/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        repo.deleteById(id);
    }
}
