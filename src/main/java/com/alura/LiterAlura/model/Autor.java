package com.alura.LiterAlura.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Min(value = 0, message = "O ano de nascimento deve ser um número positivo")
    private int anoNascimento;

    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livro> livros;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Autor(Long id, String nome, int anoNascimento, Integer anoFalecimento, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
        this.livros = livros;
    }

    public Autor() {
    }

    public Autor(String nome, int anoNascimento, Integer anoFalecimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }



    @Override
    public String toString() {
        String livrosString = livros.stream()
                .map(Livro::getTitulo)
                .collect(Collectors.joining(", "));
        return "----------Autor---------\n" +
                "Nome: " + nome + "\n" +
                "Ano de Nascimento: " + (anoNascimento > 0 ? anoNascimento : "Desconhecido") + "\n" +
                "Ano de Falecimento: " + (anoFalecimento != null ? anoFalecimento : "Vivo") + "\n" +
                "Livros: " + (livrosString.isEmpty() ? "Nenhum livro registrado" : livrosString) + "\n" +
                "------------------------";
    }
}
