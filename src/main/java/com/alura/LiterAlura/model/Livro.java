package com.alura.LiterAlura.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @NotBlank(message = "O idioma é obrigatório")
    private String idioma;

    private Integer anoPublicacao;

    private Integer numeroDownloads;

    public Livro() {
    }

    public Livro(String titulo, Autor autor, String idioma, Integer anoPublicacao, Integer numeroDowloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.anoPublicacao = anoPublicacao;
        this.numeroDownloads= numeroDowloads;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        return "----------Livro---------\n" +
                "Titulo: " + titulo + "\n" +
                "Autor: " + autor.getNome() + "\n" +
                "Idioma: " + idioma + "\n" +
                "Numero de Downloads: " + (numeroDownloads != null ? numeroDownloads : "Desconhecido") + "\n" +
                "------------------------";
    }
}
