package com.Librarium.Demo.Servicios;


import com.Librarium.Demo.Entidad.Libro;

import java.util.List;
import java.util.Optional;

public interface ServicioLibro {


    public Libro guardarLibro(Libro libro);
    public Libro actualizarLibro(Libro libro);
    public List<Libro> listarLibros();
    public Optional<Libro> buscarLibroPorId(Long id);
    public void eliminarLibro(Long id);



}
