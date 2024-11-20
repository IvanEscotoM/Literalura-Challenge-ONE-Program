package com.ivanem.retojpalibros.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        String name,
        int birth_year,
        int death_year
        ) {
}
