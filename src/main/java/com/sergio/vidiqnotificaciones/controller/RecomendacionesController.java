package com.sergio.vidiqnotificaciones.controller;

import com.sergio.vidiqnotificaciones.models.Recomendacion;
import com.sergio.vidiqnotificaciones.services.RecomendacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/recomendaciones")
@AllArgsConstructor
@Tag(name = "Recomendaciones", description = "API rest para realizar operaciones CRUD con Recomendaciones")
public class RecomendacionesController {

    final RecomendacionService recomendacionService;

    @PostMapping("/")
    @Operation(summary = "Entrypoint para crear una recomendacion")
    @ApiResponse(responseCode = "201", description = "la Recomendacion se ha creado correctamente",
            content = @Content(schema = @Schema(implementation = Recomendacion.class)))
    public Mono<Recomendacion> save(Recomendacion recomendacion) {
        return recomendacionService.save(recomendacion);
    }

    @GetMapping("/recomendaciones/tema")
    @Operation(summary = "Entrypoint para obtener recomendaciones por tema")
    @Parameter(name = "tema del video", example = "video de prueba")
    @ApiResponse(responseCode = "200", description = "la Recomendacion se ha obtenido correctamente")
    public Flux<Recomendacion> findRecomendacionesByTemaCanalContainsIgnoreCase(String tema) {
        return recomendacionService.findRecomendacionesByTemaCanalContainsIgnoreCase(tema);
    }
}
