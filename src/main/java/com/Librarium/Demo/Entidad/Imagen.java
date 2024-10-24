package com.Librarium.Demo.Entidad;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    public Imagen(String imagenId, String imagenUrl, String nombre) {
        this.imagenId = imagenId;
        this.imagenUrl = imagenUrl;
        this.nombre = nombre;
    }

    public @NotBlank String getImagenId() {
        return imagenId;
    }

    public void setImagenId(@NotBlank String imagenId) {
        this.imagenId = imagenId;
    }

    public @NotBlank String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(@NotBlank String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public @NotBlank String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
