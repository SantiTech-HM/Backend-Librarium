package com.Librarium.Demo.Servicios;

import com.Librarium.Demo.Entidad.Imagen;
import com.Librarium.Demo.Entidad.Libro;
import com.Librarium.Demo.Repositorios.RepositorioLibro;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioLibroImpl implements ServicioLibro{

    private final RepositorioLibro repositorioLibro;
    private final ServicioImagen servicioImagen;

    public ServicioLibroImpl(RepositorioLibro repositorioLibro, ServicioImagen servicioImagen) {
        this.repositorioLibro = repositorioLibro;
        this.servicioImagen = servicioImagen;
    }


    @Override
    public Libro saveLibro(Libro libro, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()){
            Imagen imagen = servicioImagen.uploadImagen(file);
            libro.setImagen(imagen);
        }
        return repositorioLibro.save(libro);
    }

    @Override
    public Libro updateLibro(Libro libro){
        return repositorioLibro.save(libro);
    }
    @Override
    public List<Libro> getLibros(){
        return repositorioLibro.findAll();
    }
    @Override
    public Optional<Libro> getLibroById(Long id){
        return repositorioLibro.findById(id);
    }
    @Override
    public void deleteLibro(Libro libro) throws IOException {
        if (libro.getImagen() != null) {
            servicioImagen.deleteImagen(libro.getImagen());
        }
        repositorioLibro.deleteById(libro.getId());
    }
    @Override
    public Libro updateLibroImagen(MultipartFile file, Libro libro) throws IOException {
        if (libro.getImagen() != null) {
            servicioImagen.deleteImagen(libro.getImagen());
        }
        Imagen newImagen = servicioImagen.uploadImagen(file);
        libro.setImagen(newImagen);
        return repositorioLibro.save(libro);
    }
}
