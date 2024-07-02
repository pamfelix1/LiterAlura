package com.alura.LiterAlura.controller;

import com.alura.LiterAlura.model.Livro;
import com.alura.LiterAlura.service.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pesquisa")
public class GutendexController {
    @Autowired
    private GutendexService gutendexService;

    @GetMapping("/titulo/{titulo}")
    public List<Livro> buscarLivrosPorTitulo(@PathVariable String titulo) {
        return gutendexService.buscarLivrosPorTitulo(titulo);
    }
}
