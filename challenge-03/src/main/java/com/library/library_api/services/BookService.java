// java
package com.library.library_api.services;

import com.library.library_api.models.AuthorEntity;
import com.library.library_api.models.BookEntity;
import com.library.library_api.records.Author;
import com.library.library_api.records.Book;
import com.library.library_api.repositories.AuthorRepository;
import com.library.library_api.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public BookEntity saveFirst(List<Book> books) {
        if (books == null || books.isEmpty()) return null;

        Book b = books.getFirst();

        String title = b.title() == null ? "" : b.title().trim();
        if (title.isEmpty()) return null; // no crear sin título

        List<Author> authors = b.authors() == null
                ? Collections.emptyList()
                : b.authors().stream()
                .filter(n -> !n.name().isEmpty())
                .distinct()
                .toList();

        Optional<BookEntity> existingOpt = bookRepository.findByTitleIgnoreCase(title);

        if (existingOpt.isEmpty()) {
            BookEntity bookEntity = new BookEntity(b);

            for (Author aut : authors) {
                AuthorEntity author = authorRepository.findByName(aut.name())
                        .orElseGet(() -> authorRepository.save(new AuthorEntity(aut)));
                bookEntity.addAuthor(author);
            }
            return bookRepository.save(bookEntity);
        }

        return null;
    }

    @Transactional(readOnly = true)
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public List<AuthorEntity> findAllAuthors() {
        return authorRepository.findAll();
    }

    public List<AuthorEntity> findAuthorsAliveInYear(int year) {
        return authorRepository.findAuthorsAliveInYear(year);
    }

    @Transactional(readOnly = true)
    public List<BookEntity> findBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }
}
