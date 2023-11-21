package com.sergio.vidiqnotificaciones.repositories;

import com.sergio.vidiqnotificaciones.models.Recomendacion;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RecomendacionRepository extends R2dbcRepository<Recomendacion, String> {
    Flux<Recomendacion> findRecomendacionesByTemaContainsIgnoreCase(String tema);
}
