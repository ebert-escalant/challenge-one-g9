package com.library.library_api.repositories;

import com.library.library_api.models.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByName(String name);

    @Query("select a from AuthorEntity a where (:year >= a.birthYear and (:year <= a.deathYear or a.deathYear is null))")
    public List<AuthorEntity> findAuthorsAliveInYear(Integer year);
}
