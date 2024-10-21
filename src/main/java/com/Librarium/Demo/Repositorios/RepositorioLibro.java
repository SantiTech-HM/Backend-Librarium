package com.Librarium.Demo.Repositorios;

import com.Librarium.Demo.Entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioLibro extends JpaRepository<Libro, Long> {
}
