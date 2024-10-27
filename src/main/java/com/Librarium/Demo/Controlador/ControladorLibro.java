package com.Librarium.Demo.Controlador;

import com.Librarium.Demo.Entidad.Libro;
import com.Librarium.Demo.Servicios.ServicioLibroImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/libro")
@CrossOrigin(value = "http://localhost:4200/")
public class ControladorLibro {

    @Autowired
    ServicioLibroImpl servicioLibroImpl;

    @PostMapping
    public ResponseEntity<Libro> saveLibro(@RequestPart("libro") Libro libro, @RequestPart("file")MultipartFile file) {
        try {
            Libro savedLibro = servicioLibroImpl.saveLibro(libro, file);
            return new ResponseEntity<>(savedLibro, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}/image")
    public ResponseEntity<Libro> updateLibroImagen(@PathVariable Long id, @RequestPart("file") MultipartFile file) throws IOException {
        Optional<Libro> libro = servicioLibroImpl.getLibroById(id);
        if (libro.isPresent()) {
            Libro updatedLibro = servicioLibroImpl.updateLibroImagen(file, libro.get());
            return new ResponseEntity<>(updatedLibro, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Libro> updateLibro(@RequestBody Libro libro){
        try {
            Libro savedLibro = servicioLibroImpl.updateLibro(libro);
            return new ResponseEntity<>(savedLibro, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros(){
        return new ResponseEntity<>(servicioLibroImpl.getLibros(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = servicioLibroImpl.getLibroById(id);
        return libro.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) throws IOException {
        Optional<Libro> libro = servicioLibroImpl.getLibroById(id);
        if (libro.isPresent()){
            servicioLibroImpl.deleteLibro(libro.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
