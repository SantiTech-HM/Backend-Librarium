package com.Librarium.Demo.Entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String autor;

    @NotBlank
    private String genero;

    @NotNull
    private String paginas;

    @NotNull
    private Double precio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imagen_id", referencedColumnName = "id")
    private Imagen imagen;

    public @NotBlank String getAutor() {
        return autor;
    }

    public void setAutor(@NotBlank String autor) {
        this.autor = autor;
    }

    public @NotBlank String getGenero() {
        return genero;
    }

    public void setGenero(@NotBlank String genero) {
        this.genero = genero;
    }


    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public @NotNull String getPaginas() {
        return paginas;
    }

    public void setPaginas(@NotNull String paginas) {
        this.paginas = paginas;
    }

    public @NotNull Double getPrecio() {
        return precio;
    }

    public void setPrecio(@NotNull Double precio) {
        this.precio = precio;
    }

    public @NotBlank String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
