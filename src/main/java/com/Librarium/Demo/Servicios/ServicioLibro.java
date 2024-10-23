package com.Librarium.Demo.Servicios;


import com.Librarium.Demo.Entidad.Libro;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ServicioLibro {


    Libro saveLibro(Libro libro, MultipartFile file) throws IOException;
    Libro updateLibro(Libro libro);
    List<Libro> getLibros();
    Optional<Libro> getLibroById(Long id);
    void deleteLibro(Libro libro) throws IOException;
    Libro updateLibroImagen(MultipartFile file, Libro libro) throws IOException;
}
