package com.Librarium.Demo.Entidad;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String imagenUrl;

    @NotBlank
    private String imagenId;



    public Imagen(String nombre, String imagenUrl, String imagenId) {
        this.nombre = nombre;
        this.imagenUrl = imagenUrl;
        this.imagenId = imagenId;
    }


}
