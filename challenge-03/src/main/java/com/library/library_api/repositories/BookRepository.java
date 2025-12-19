package com.library.library_api.repositories;

import com.library.library_api.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findByTitleIgnoreCase(String title);

    @Query("select b from BookEntity b where :language member of b.languages")
    List<BookEntity> findByLanguage(String language);
}
