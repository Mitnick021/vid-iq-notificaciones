package com.sergio.vidiqnotificaciones.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="recomendaciones")
public class Recomendacion {

    @Id
    @Schema(description = "Identificador de la recomendacion", example = "12321")
    private String id;

    @Column(name="user_id")
    @Schema(description = "Identificador del usuario", example = "12321")
    private String userId;

    @Column(name="video_id")
    @Schema(description = "Identificador del video", example = "12321")
    private String videoId;

    @Column(name="duracion")
    @Schema(description = "Duracion del video", example = "120 segundos")
    private Integer duracion;

    @Column(name="tema")
    @Schema(description = "Tema del video", example = "Prueba")
    private String tema;
}
