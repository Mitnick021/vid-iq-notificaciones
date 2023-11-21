package com.sergio.vidiqnotificaciones.services;

import com.sergio.vidiqnotificaciones.models.Notificacion;
import com.sergio.vidiqnotificaciones.repositories.NotificacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public Mono<Notificacion> save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Flux<Notificacion> findAll() {
        return notificacionRepository.findAll().onErrorResume(throwable -> {
                    return  Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontraron notificaciones").getMostSpecificCause()));
    }

    public Mono<Notificacion> findNotificacionesByNombreVideoContainsIgnoreCase(String nombreVideo) {
        return notificacionRepository.findNotificacionesByNombreVideoContainsIgnoreCase(nombreVideo).onErrorResume(throwable -> {
                    return  Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontro la notificacion").getMostSpecificCause()));
    }

    public Flux<Notificacion> findNotificacionesByNombreCanalContainsIgnoreCase(String nombreCanal) {
        return notificacionRepository.findNotificacionesByNombreCanalContainsIgnoreCase(nombreCanal).onErrorResume(throwable -> {
                    return  Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontro la notificacion").getMostSpecificCause()));
    }
}
