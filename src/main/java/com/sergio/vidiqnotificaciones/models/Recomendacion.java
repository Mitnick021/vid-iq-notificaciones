package com.sergio.vidiqnotificaciones.models;

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
    private String id;

    @Column(name="user_id")
    private String userId;

    @Column(name="video_id")
    private String videoId;

    @Column(name="duracion")
    private Integer duracion;

    @Column(name="tema")
    private String tema;
}
