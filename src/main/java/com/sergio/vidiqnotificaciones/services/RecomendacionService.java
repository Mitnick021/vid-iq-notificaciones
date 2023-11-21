package com.sergio.vidiqnotificaciones.services;

import com.sergio.vidiqnotificaciones.models.Recomendacion;
import com.sergio.vidiqnotificaciones.repositories.RecomendacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RecomendacionService {

    private final RecomendacionRepository recomendacionRepository;

    public Mono<Recomendacion> save(Recomendacion recomendacion) {
        return recomendacionRepository.save(recomendacion);
    }

    public Flux<Recomendacion> findRecomendacionesByTemaCanalContainsIgnoreCase(String tema) {
        return recomendacionRepository.findRecomendacionesByTemaContainsIgnoreCase(tema).onErrorResume(throwable -> {
                    return  Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontraron recomendaciones").getMostSpecificCause()));    }
}
