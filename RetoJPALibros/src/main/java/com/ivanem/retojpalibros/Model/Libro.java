package com.ivanem.retojpalibros.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "libros")

public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authors=new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> languages;

    int download_count;


    public Libro(String title, List<DatosAutor> authors, List<String> languages, int download_count) {
        this.title = title;
        this.authors.add(authors.get(0).name());
        this.authors.add(String.valueOf(authors.get(0).birth_year()));
        this.authors.add(String.valueOf(authors.get(0).death_year()));
        this.languages = languages;
        this.download_count = download_count;

    }

    public Libro() {

    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorsName() {
        return authors.get(0);
    }
    public int getAuthorsBirthYear() {
        return Integer.parseInt(authors.get(1));
    }
    public int getAuthorsDeathYear() {
        return Integer.parseInt(authors.get(2));
    }


    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }
//    public void setId(Long id) {
//        this.id = id;
//    }

//    public Long getId() {
//        return id;
//    }
    @Override
    public String toString() {
        return "\nTitulo:"+title+"\nAutor(es): "+authors.get(0)+"\nLenguajes: "+languages.get(0)+"\nVeces descargado: "+download_count+"\n";
    }


}
