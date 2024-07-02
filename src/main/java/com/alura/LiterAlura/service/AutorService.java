package com.alura.LiterAlura.service;

import com.alura.LiterAlura.Repository.AutorRepository;
import com.alura.LiterAlura.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;


    public List<Autor> obterTodosAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> obterAutoresPorAnoNascimento(int ano) {
        return autorRepository.findByAnoNascimento(ano);
    }

    public List<Autor> obterAutoresVivosEmAno(int ano) {
        return autorRepository.findByAnoFalecimentoIsNullOrAnoFalecimentoGreaterThanEqual(ano);
    }

    public void salvarAutor(Autor autor) {
        autorRepository.save(autor);
    }

    public void salvarAutores(List<Autor> autores) {
        autorRepository.saveAll(autores);
    }

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    public Autor buscarAutorComLivros(Long autorId) {
        Autor autor = autorRepository.findById(autorId).orElse(null);
        if (autor != null) {
            autor.getLivros().size();
        }
        return autor;}
}
