package com.Librarium.Demo.Servicios;

import com.Librarium.Demo.Entidad.Libro;
import com.Librarium.Demo.Repositorios.RepositorioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpleServicioLibro implements ServicioLibro{

    @Autowired
    private RepositorioLibro repositorioLibro;

    @Override
    public Libro guardarLibro(Libro libro) {
        return repositorioLibro.save(libro);
    }

    @Override
    public Libro actualizarLibro(Libro libro) {
        return repositorioLibro.save(libro);
    }

    @Override
    public List<Libro> listarLibros() {
        return repositorioLibro.findAll();
    }

    @Override
    public Optional<Libro> buscarLibroPorId(Long id) {
        return repositorioLibro.findById(id);
    }

    @Override
    public void eliminarLibro(Long id) {
        repositorioLibro.deleteById(id);
    }
}
