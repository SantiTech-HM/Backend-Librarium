package com.Librarium.Demo.Servicios;

import com.Librarium.Demo.Entidad.Imagen;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ServicioImagen {

    Imagen uploadImagen(MultipartFile file) throws IOException;
    void deleteImagen(Imagen imagen) throws IOException;
}
