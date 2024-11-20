package com.ivanem.retojpalibros.Repositorio;

import com.ivanem.retojpalibros.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepositorio extends JpaRepository <Libro,Long> {
    boolean existsByTitle(String titulo);

}
