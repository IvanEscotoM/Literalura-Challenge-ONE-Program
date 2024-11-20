package com.ivanem.retojpalibros.Main;


import com.ivanem.retojpalibros.Model.Datos;
import com.ivanem.retojpalibros.Model.Libro;
import com.ivanem.retojpalibros.Model.LibroR;
import com.ivanem.retojpalibros.Repositorio.LibroRepositorio;
import com.ivanem.retojpalibros.Service.ApiService;
import com.ivanem.retojpalibros.Service.ConversorData;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuMain {
    Scanner sc = new Scanner(System.in);
    ApiService apiService = new ApiService();
    boolean marcha=true;
    private ConversorData conversor = new ConversorData();
    private final String URL_BASE= "https://gutendex.com/books/?search=";
    private LibroRepositorio libroRepositorio;

    public MenuMain(LibroRepositorio repositorio){
        this.libroRepositorio = repositorio;

    }


    public void menuMain(){




        System.out.println("Bienvenid@ al programa JPALibros");
        limpiarPantalla(sc);
        while(marcha){
            System.out.println("Elige la opcion a traves de su numero:");
            System.out.println("1.- Buscar libro por titulo.\n2.- Listar libros registrados.\n3.- Listar autores registrados\n4.- Listar autores vivos en un determinado periodo de tiempo \n5.- Listar libros por idioma.\n0.- Salir del programa.");
            String eleccion = sc.nextLine();
            switch (eleccion){
                case "1":
                    System.out.println("Escribe el titulo del libro que quieres consultar:");
                    String titulo = sc.nextLine();
                    //try {

                        String json=apiService.obtenerDatos(URL_BASE+titulo.replace(" ","+"));
                        Datos datos= conversor.obtenerDatos(json, Datos.class);
                        try {
                            LibroR libroR=datos.results().stream().filter(l->l.title().toLowerCase().contains(titulo.toLowerCase())).findFirst().get();
                            //Libro libro= new Libro(libroR.title(),libroR.authors(),libroR.languages(),libroR.download_count());
                            System.out.println("Este libro es correcto? Escribe SI para agregarlo a la base de datos.\n(Cualquier otro input sera tomado como negativo a agregar el libro.)");
                            System.out.println("_______");
                            System.out.println("Titulo:"+libroR.title()+"\nAutor(es): "+libroR.authors().get(0).name()+"\nLenguajes: "+libroR.languages().get(0)+"\nVeces descargado: "+libroR.download_count());
                            System.out.println("-------");
                            String eleccion2= sc.nextLine();
                            if(eleccion2.toLowerCase().equals("si")){

                                    if(libroRepositorio.existsByTitle(libroR.title())){
                                        System.out.println("El libro ya existe.\nContinua con otra busqueda.");

                                    } else{
                                        Libro libro= new Libro(libroR.title(),libroR.authors(),libroR.languages(),libroR.download_count());
                                        libroRepositorio.save(libro);
                                        System.out.println("Agregado a la base de datos.");
                                    }

                            }
                        } catch (Exception e) {
                            System.out.println("No es posible imprimir este titulo, por falta de elementos clave.");
                        }


                    limpiarPantalla(sc);
                    break;
                case "2":
                    System.out.println(libroRepositorio.findAll());
                    limpiarPantalla(sc);
                    break;
                case "3":
                    System.out.println("Autores: ");
                    libroRepositorio.findAll().stream().map(l->l.getAuthorsName()).distinct().forEach(System.out::println);
                    limpiarPantalla(sc);
                    break;
                case "4":
                    System.out.println("Escribe año de inicio:");
                    int a=Integer.valueOf(sc.nextLine());
                    System.out.println("Escribe año de fin:");
                    int b=Integer.valueOf(sc.nextLine());
                    if(a>b){
                        System.out.println("Tu fecha de inicio es mayor a la final, vuelve a intentarlo.");
                    } else {
                        System.out.println("Autores vivos en ese periodo de tiempo: ");

                        List<String> autores=libroRepositorio.findAll().stream().filter(l->l.getAuthorsBirthYear()>=a&&l.getAuthorsDeathYear()<b).map(libro -> libro.getAuthorsName()).distinct().collect(Collectors.toList());
                        if(autores.size()>0){
                            System.out.println("Lista de autores: ");
                            autores.forEach(System.out::println);
                        } else{
                            System.out.println("No hay autores existentes en la base de datos en ese periodo de tiempo.");
                        }
                    }
                    limpiarPantalla(sc);
                    break;
                case "5":
                    System.out.println("Que idioma quieres buscar?");
                    System.out.println("en-English\nes-Espanol\npt-Portugues\nit-Italiano");
                    String idioma = sc.nextLine();
                    List<Libro> libros=libroRepositorio.findAll().stream().filter(l->l.getLanguages().get(0).equals(idioma)).collect(Collectors.toList());
                    if(libros.size()>0){
                        System.out.println("Lista de libros en idioma "+idioma+": ");
                        libros.forEach(System.out::println);
                    } else{
                        System.out.println("No existen actualmente libros en la base de datos en el idioma "+idioma+".");
                    }
                    limpiarPantalla(sc);
                    break;
                case "0":

                    marcha=false;
                    limpiarPantalla(sc);
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    limpiarPantalla(sc);
                    break;

            }

        System.out.println("Gracias por usar JPALibros. Vuelve pronto!");

        }
    }


    public static void limpiarPantalla(Scanner sc){

        System.out.println("Presiona Enter para continuar.");
        sc.nextLine();
        for(int i=0;i<100;i++){
            System.out.println();
        }
        System.out.println();
    }
}
