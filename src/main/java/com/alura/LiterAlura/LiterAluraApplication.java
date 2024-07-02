package com.alura.LiterAlura;

import com.alura.LiterAlura.model.Autor;
import com.alura.LiterAlura.model.Livro;
import com.alura.LiterAlura.service.AutorService;
import com.alura.LiterAlura.service.GutendexService;
import com.alura.LiterAlura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = {"com.alura.LiterAlura"})
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private GutendexService gutendexService;
	@Autowired
	private LivroService livroService;
	@Autowired
	private AutorService autorService;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			System.out.println("Escolha o número de sua opção:");
			System.out.println("1. Buscar livros por título");
			System.out.println("2. Listar livros registrados");
			System.out.println("3. Listar autores registrados");
			System.out.println("4. Listar autores em determinado ano");
			System.out.println("5. Listar livros em um determinado idioma");
			System.out.println("6. Listar autores vivos em determinado ano");
			System.out.println("0. Sair");
			while (!scanner.hasNextInt()) {
				System.out.println("Opção inválida! Por favor, digite um número:");
				scanner.next();
			}
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
				case 1:
					System.out.println("Digite o título do livro:");
					String titulo = scanner.nextLine();
					List<Livro> livros = gutendexService.buscarLivrosPorTitulo(titulo);
					if (livros.isEmpty()) {
						System.out.println("Nenhum livro encontrado com o título: " + titulo);
					} else {
						livroService.salvarLivros(livros);
						livros.forEach(System.out::println);
					}
					break;
				case 2:
					List<Livro> todosLivros = livroService.obterTodosLivros();
					if (todosLivros.isEmpty()) {
						System.out.println("Nenhum livro registrado.");
					} else {
						todosLivros.forEach(System.out::println);
					}
					break;
				case 3:
					List<Autor> todosAutores = autorService.obterTodosAutores();
					if (todosAutores.isEmpty()) {
						System.out.println("Nenhum autor registrado.");
					} else {
						todosAutores.forEach(System.out::println);
					}
					break;
				case 4:
					System.out.println("Digite o ano de nascimento dos autores:");
					while (!scanner.hasNextInt()) {
						System.out.println("Ano inválido! Por favor, digite um número:");
						scanner.next();
					}
					int anoNascimento = scanner.nextInt();
					List<Autor> autoresPorAno = autorService.obterAutoresPorAnoNascimento(anoNascimento);
					if (autoresPorAno.isEmpty()) {
						System.out.println("Nenhum autor encontrado para o ano: " + anoNascimento);
					} else {
						autoresPorAno.forEach(System.out::println);
					}
					break;
				case 5:
					System.out.println("Digite o idioma:");
					String idioma = scanner.nextLine();
					List<Livro> livrosPorIdioma = livroService.obterLivrosPorIdioma(idioma);
					if (livrosPorIdioma.isEmpty()) {
						System.out.println("Nenhum livro encontrado para o idioma: " + idioma);
					} else {
						livrosPorIdioma.forEach(System.out::println);
					}
					break;
				case 6:
					System.out.println("Digite o ano:");
					while (!scanner.hasNextInt()) {
						System.out.println("Ano inválido! Por favor, digite um número:");
						scanner.next();
					}
					int ano = scanner.nextInt();
					List<Autor> autoresVivos = autorService.obterAutoresVivosEmAno(ano);
					if (autoresVivos.isEmpty()) {
						System.out.println("Nenhum autor vivo encontrado para o ano: " + ano);
					} else {
						autoresVivos.forEach(System.out::println);
					}
					break;
				case 0:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida!");
			}
		} while (opcao != 0);

		scanner.close();
	}
}
