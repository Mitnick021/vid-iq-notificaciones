package com.sergio.vidiqnotificaciones.repositories;

import com.sergio.vidiqnotificaciones.models.Notificacion;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface NotificacionRepository  extends R2dbcRepository<Notificacion, String> {
    Mono<Notificacion> findNotificacionesByNombreVideoContainsIgnoreCase(String nombreVideo);
    Flux<Notificacion> findNotificacionesByNombreCanalContainsIgnoreCase(String nombreCanal);
}
