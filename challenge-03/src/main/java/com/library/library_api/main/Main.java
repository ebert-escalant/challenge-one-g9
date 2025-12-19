package com.library.library_api.main;

import com.library.library_api.models.AuthorEntity;
import com.library.library_api.models.BookEntity;
import com.library.library_api.records.ApiResponse;
import com.library.library_api.records.Book;
import com.library.library_api.services.ApiRequest;
import com.library.library_api.services.BookService;
import com.library.library_api.services.Mapper;
import org.aspectj.weaver.ast.Var;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private final BookService bookService;

    public Main(BookService bookService) {
        this.bookService = bookService;
    }

    private Scanner scanner = new Scanner(System.in);
    private ApiRequest apiRequest = new ApiRequest();
    private Mapper mapper = new Mapper();

    private static final String BASE_URL = "https://gutendex.com/books";

    public void execute() {
        var option = -1;

        do {
            System.out.println("Elija la opción a través de su número: ");
            System.out.println("1. Buscar y agregar libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en determinado año");
            System.out.println("5. Buscar libros por idioma");
            System.out.println("0. Salir");

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Ingrese el título del libro que desea buscar: ");
                    String title = scanner.nextLine();
                    addBook(title);
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    listAllAuthors();
                    break;
                case 4:
                    System.out.print("Ingrese el año para buscar autores vivos: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    listAuthorsAliveInYear(year);
                    break;
                case 5:
                    System.out.print("Ingrese el idioma para buscar libros: ");
                    String language = scanner.nextLine();
                    listBooksByLanguage(language);
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        } while (option != 0);
    }

    private void addBook(String title) {
        try {
            String encoded = URLEncoder.encode(title, StandardCharsets.UTF_8);
            String url = BASE_URL + "/?search=" + encoded;
            var json = apiRequest.fetchData(url);

            if (json == null || json.isBlank()) {
                System.out.println("No se obtuvo respuesta del servicio o la respuesta está vacía.");
                return;
            }

            ApiResponse response = mapper.fromJson(json, ApiResponse.class);
            List<Book> books = response.data();

            if (books == null || books.isEmpty()) {
                System.out.println("No se encontraron libros para: " + title);
                return;
            }

            var savedBook = bookService.saveFirst(books);
            if (savedBook != null) {
                System.out.println("----- LIBRO -----");
                System.out.println("Título: " + savedBook.getTitle());
                System.out.println("Autor: " + savedBook.getAuthors().stream().map(a -> a.getName()).collect(Collectors.joining(", ")));
                System.out.println("Idioma: " + (savedBook.getLanguages() != null && !savedBook.getLanguages().isEmpty() ? String.join(", ", savedBook.getLanguages()) : "N/A"));
                System.out.println("Número de descargas: " + savedBook.getDownloadCount());
                System.out.println("-----------------");
            } else {
                System.out.println("El libro ya existe o no pudo guardarse.");
            }
        } catch (Exception e) {
            System.err.println("Error al obtener datos: " + e.getMessage());
        }
    }

    private void listBooks() {
        var books = bookService.findAll();

        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        books.forEach(book -> {
            System.out.println("----- LIBRO -----");
            System.out.println("Título: " + book.getTitle());
            System.out.println("Autor: " + book.getAuthors().stream().map(AuthorEntity::getName).collect(Collectors.joining(", ")));
            System.out.println("Idioma: " + (book.getLanguages() != null && !book.getLanguages().isEmpty() ? String.join(", ", book.getLanguages()) : "N/A"));
            System.out.println("Número de descargas: " + book.getDownloadCount());
            System.out.println("-----------------");
        });
    }

    private void listAllAuthors() {
        var authors = bookService.findAllAuthors();

        if (authors.isEmpty()) {
            System.out.println("No hay autores registrados.");
            return;
        }

        authors.forEach(author -> {
            System.out.println("----- AUTOR -----");
            System.out.println("Nombre: " + author.getName());
            System.out.println("Año de nacimiento: " + (author.getBirthYear() != null ? author.getBirthYear() : "N/A"));
            System.out.println("Año de fallecimiento: " + (author.getDeathYear() != null ? author.getDeathYear() : "N/A"));
            System.out.println("-----------------");
        });
    }

    private void listAuthorsAliveInYear(int year) {
        var authors = bookService.findAuthorsAliveInYear(year);

        if (authors.isEmpty()) {
            System.out.println("No hay autores vivos en el año " + year);
            return;
        }

        authors.forEach(author -> {
            System.out.println("----- AUTOR -----");
            System.out.println("Nombre: " + author.getName());
            System.out.println("Año de nacimiento: " + (author.getBirthYear() != null ? author.getBirthYear() : "N/A"));
            System.out.println("Año de fallecimiento: " + (author.getDeathYear() != null ? author.getDeathYear() : "N/A"));
            System.out.println("-----------------");
        });
    }

    private void listBooksByLanguage(String language) {
        var books = bookService.findBooksByLanguage(language);

        if (books.isEmpty()) {
            System.out.println("No hay libros registrados en el idioma: " + language);
            return;
        }

        books.forEach(book -> {
            System.out.println("----- LIBRO -----");
            System.out.println("Título: " + book.getTitle());
            System.out.println("Autor: " + book.getAuthors().stream().map(AuthorEntity::getName).collect(Collectors.joining(", ")));
            System.out.println("Idioma: " + (book.getLanguages() != null && !book.getLanguages().isEmpty() ? String.join(", ", book.getLanguages()) : "N/A"));
            System.out.println("Número de descargas: " + book.getDownloadCount());
            System.out.println("-----------------");
        });
    }
}
