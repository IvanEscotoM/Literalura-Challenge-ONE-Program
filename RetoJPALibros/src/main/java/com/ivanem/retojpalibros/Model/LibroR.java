package com.ivanem.retojpalibros.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroR(
     String title,

     List<DatosAutor> authors,

     List<String> languages,

     int download_count) {
}
