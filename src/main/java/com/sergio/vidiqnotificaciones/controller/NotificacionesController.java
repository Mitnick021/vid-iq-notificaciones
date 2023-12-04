package com.sergio.vidiqnotificaciones.controller;

import com.sergio.vidiqnotificaciones.models.Notificacion;
import com.sergio.vidiqnotificaciones.services.NotificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notificaciones")
@AllArgsConstructor
@Tag(name = "Notificaciones", description = "API rest para realizar operaciones CRUD con Notificaciones")
public class NotificacionesController {

    final NotificacionService notificacionService;

    @PostMapping("/")
    @Operation(summary = "Entrypoint para crear una notificacion")
    @ApiResponse(responseCode = "201", description = "la Notificacion se ha creado correctamente",
            content = @Content(schema = @Schema(implementation = Notificacion.class)))
    public Mono<Notificacion> crearNotificacion(Notificacion notificacion) {
        return notificacionService.save(notificacion);
    }

    @GetMapping("/notificaciones/nombreCanal")
    @Operation(summary = "Entrypoint para obtener notificaciones por nombre de canal")
    @Parameter(name = "nombre del video", example = "video de prueba")
    @ApiResponse(responseCode = "200", description = "la Notificacion se ha obtenido correctamente")
    public Flux<Notificacion> consultarNotificacionesNombreVideo(String nombreVideo) {
        return notificacionService.findNotificacionesByNombreCanalContainsIgnoreCase(nombreVideo);
    }

    @GetMapping("/notificaciones/nombreVideo")
    @Operation(summary = "Entrypoint para obtener notificaciones por nombre de video")
    @Parameter(name = "nombre del canal", example = "canal de prueba")
    @ApiResponse(responseCode = "200", description = "la Notificacion se ha obtenido correctamente")
    public Mono<Notificacion> consultarNotificacionesNombreCanal(String nombreCanal) {
        return notificacionService.findNotificacionesByNombreVideoContainsIgnoreCase(nombreCanal);
    }
}
