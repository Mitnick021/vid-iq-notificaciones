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
@Table(name="notificaciones")
public class Notificacion {

    @Id
    private String id;

    @Column(name="user_id")
    private String userId;

    @Column(name="nombre_video")
    private String nombreVideo;

    @Column(name="nombre_canal")
    private String nombreCanal;
}
