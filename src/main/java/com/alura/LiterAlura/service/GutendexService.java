package com.alura.LiterAlura.service;

import com.alura.LiterAlura.model.Autor;
import com.alura.LiterAlura.model.Livro;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GutendexService {

    private static final String GUTENDEX_API_URL = "https://gutendex.com/books";

    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = GUTENDEX_API_URL + "?search=" + titulo;
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
        List<Livro> livros = new ArrayList<>();

        if (results != null && !results.isEmpty()) {
            for (Map<String, Object> result : results) {
                String livroTitulo = (String) result.get("title");
                List<Map<String, String>> authors = (List<Map<String, String>>) result.get("authors");
                String idioma = (String) ((List<String>) result.get("languages")).get(0);
                Integer anoPublicacao = result.get("download_count") != null ?
                        Integer.parseInt(result.get("download_count").toString()) : null;
                Integer numeroDownloads = result.get("download_count") != null ?
                        Integer.parseInt(result.get("download_count").toString()) : null;

                Autor autor = new Autor();
                if (!authors.isEmpty()) {
                    autor.setNome(authors.get(0).get("name"));
                }

                livros.add(new Livro(livroTitulo, autor, idioma, anoPublicacao, numeroDownloads));
            }
        }
        return livros;
    }
}
