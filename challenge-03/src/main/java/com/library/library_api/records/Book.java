package com.library.library_api.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(
    @JsonAlias("id") Integer id,
    @JsonAlias("title") String title,
    @JsonAlias("authors") List<Author> authors,
    @JsonAlias("languages") List<String> languages,
    @JsonAlias("download_count") Integer downloadCount
) { }
