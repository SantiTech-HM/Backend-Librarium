package com.Librarium.Demo.Servicios;

import com.Librarium.Demo.Entidad.Imagen;
import com.Librarium.Demo.Repositorios.RepositorioImagen;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


@Service

public class ServcioImagenImpl implements ServicioImagen{

    private final CloudinaryServicio cloudinaryServicio;
    private final RepositorioImagen repositorioImagen;

    public ServcioImagenImpl(CloudinaryServicio cloudinaryServicio, RepositorioImagen repositorioImagen) {
        this.cloudinaryServicio = cloudinaryServicio;
        this.repositorioImagen = repositorioImagen;
    }

    @Override
    public Imagen uploadImagen(MultipartFile file) throws IOException {
        Map uploadResult = cloudinaryServicio.upload(file);
        String imagenUrl = (String) uploadResult.get("url");
        String imagenId = (String) uploadResult.get("public_id");
        Imagen imagen = new Imagen(file.getOriginalFilename(), imagenUrl, imagenId);
        return repositorioImagen.save(imagen);
    }

    @Override
    public void deleteImagen(Imagen imagen) throws IOException {
        cloudinaryServicio.delete(imagen.getImagenId());
        repositorioImagen.deleteById(imagen.getId());
    }

}
