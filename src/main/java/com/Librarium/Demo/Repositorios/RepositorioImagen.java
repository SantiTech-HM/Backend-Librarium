package com.Librarium.Demo.Repositorios;

import com.Librarium.Demo.Entidad.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioImagen extends JpaRepository<Imagen, Long>{
}
