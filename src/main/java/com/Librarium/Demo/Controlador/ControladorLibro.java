package com.Librarium.Demo.Controlador;

import com.Librarium.Demo.Entidad.Libro;
import com.Librarium.Demo.Servicios.ImpleServicioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/libro")
@CrossOrigin(value = "http://localhost:4200")
public class ControladorLibro {

    @Autowired
    private ImpleServicioLibro servicioLibro;

    @PostMapping
    public ResponseEntity<Libro> guardarLibro(@RequestBody  Libro libro) {
        try {
            Libro guardarLibro = servicioLibro.guardarLibro(libro);
            return new ResponseEntity<> (guardarLibro, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping
    public ResponseEntity<Libro> actualizarLibro(@RequestBody  Libro libro) {
        try {
            Libro guardarLibro = servicioLibro.actualizarLibro(libro);
            return new ResponseEntity<> (guardarLibro, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        return new ResponseEntity<>(servicioLibro.listarLibros() ,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarLibroPorId(@PathVariable Long id) {
        Optional<Libro> libro = servicioLibro.buscarLibroPorId(id);
        return libro.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id){
        Optional<Libro> libro = servicioLibro.buscarLibroPorId(id);

        if(libro.isPresent()){
            servicioLibro.eliminarLibro(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
