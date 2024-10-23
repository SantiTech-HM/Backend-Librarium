package com.Librarium.Demo.Entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
}
