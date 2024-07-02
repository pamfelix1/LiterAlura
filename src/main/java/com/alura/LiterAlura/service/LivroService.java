package com.alura.LiterAlura.service;

import com.alura.LiterAlura.Repository.LivroRepository;
import com.alura.LiterAlura.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> obterTodosLivros() {
        return livroRepository.findAll();
    }

    public List<Livro> obterLivrosPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }

    public void salvarLivro(Livro livro) {
        livroRepository.save(livro);
    }

    public void salvarLivros(List<Livro> livros) {
        livroRepository.saveAll(livros);
    }
}
