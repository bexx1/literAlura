package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(String title,
                       Author author,
                       List<String> languages,
                       Integer download_count ) {
}
