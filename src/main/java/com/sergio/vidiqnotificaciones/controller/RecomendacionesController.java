package com.sergio.vidiqnotificaciones.controller;

import com.sergio.vidiqnotificaciones.models.Recomendacion;
import com.sergio.vidiqnotificaciones.services.RecomendacionService;
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
public class RecomendacionesController {

    final RecomendacionService recomendacionService;

    @PostMapping("/")
    public Mono<Recomendacion> save(Recomendacion recomendacion) {
        return recomendacionService.save(recomendacion);
    }

    @GetMapping("/recomendaciones/tema")
    public Flux<Recomendacion> findRecomendacionesByTemaCanalContainsIgnoreCase(String tema) {
        return recomendacionService.findRecomendacionesByTemaCanalContainsIgnoreCase(tema);
    }
}
