package com.alura.LiterAlura.controller;

import com.alura.LiterAlura.model.Autor;
import com.alura.LiterAlura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> obterTodosAutores() {
        return autorService.obterTodosAutores();
    }

    @GetMapping("/ano/{ano}")
    public List<Autor> obterAutoresPorAnoNascimento(@PathVariable int ano) {
        return autorService.obterAutoresPorAnoNascimento(ano);
    }

    @GetMapping("/vivos/{ano}")
    public List<Autor> obterAutoresVivosEmAno(@PathVariable int ano) {
        return autorService.obterAutoresVivosEmAno(ano);
    }

    @PostMapping
    public void adicionarAutor(@RequestBody Autor autor) {
        autorService.salvarAutor(autor);
    }
}
