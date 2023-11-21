package com.sergio.vidiqnotificaciones.controller;

import com.sergio.vidiqnotificaciones.models.Notificacion;
import com.sergio.vidiqnotificaciones.services.NotificacionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notificaciones")
@AllArgsConstructor
public class NotificacionesController {

    final NotificacionService notificacionService;

    @PostMapping("/")
    public Mono<Notificacion> crearNotificacion(Notificacion notificacion){
        return notificacionService.save(notificacion);
    }

    @GetMapping("/notificaciones/nombreCanal")
    public Flux<Notificacion> consultarNotificacionesNombreVideo(String nombreVideo){
        return notificacionService.findNotificacionesByNombreCanalContainsIgnoreCase(nombreVideo);
    }

    @GetMapping("/notificaciones/nombreVideo")
    public Mono<Notificacion> consultarNotificacionesNombreCanal(String nombreCanal){
        return notificacionService.findNotificacionesByNombreVideoContainsIgnoreCase(nombreCanal);
    }
}
