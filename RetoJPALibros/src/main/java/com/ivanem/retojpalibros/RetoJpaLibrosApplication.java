package com.ivanem.retojpalibros;

import com.ivanem.retojpalibros.Main.MenuMain;
import com.ivanem.retojpalibros.Repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class RetoJpaLibrosApplication implements CommandLineRunner {
    @Autowired
    private LibroRepositorio libroRepositorio;

    public static void main(String[] args) {
        SpringApplication.run(RetoJpaLibrosApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        MenuMain menu = new MenuMain(libroRepositorio);
        menu.menuMain();
    }

}
