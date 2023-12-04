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
@Table(name="notificaciones")
@Schema(description = "Modelo de Notificacion")
public class Notificacion {

    @Id
    @Schema(description = "Identificador de la notificacion", example = "12321")
    private String id;

    @Column(name="user_id")
    @Schema(description = "Identificador del usuario", example = "12321")
    private String userId;

    @Column(name="nombre_video")
    @Schema(description = "Nombre del video", example = "12321")
    private String nombreVideo;

    @Column(name="nombre_canal")
    @Schema(description = "Nombre del canal", example = "12321")
    private String nombreCanal;
}
